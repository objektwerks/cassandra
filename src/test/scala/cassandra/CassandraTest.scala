package cassandra

import com.datastax.driver.core.Cluster
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class CassandraTest extends FunSuite with BeforeAndAfterAll {
  val cluster = Cluster.builder.addContactPoint("127.0.0.1").build()
  val session = cluster.connect()

  override protected def beforeAll(): Unit = {
    session.execute("DROP KEYSPACE IF EXISTS test;")
    session.execute("CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };")
    session.execute("CREATE TABLE test.kv(key text PRIMARY KEY, value int);")
  }

  override protected def afterAll(): Unit = {
    session.close()
    cluster.close()
  }

  test("write -> read") {
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k1', 1);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k2', 2);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k3', 3);")
    val list = session.execute("select * from test.kv").all
    assert(list.size() == 3)
  }
}