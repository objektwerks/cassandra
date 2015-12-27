package cassandra

import com.datastax.driver.core.Cluster
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class CassandraTest extends FunSuite with BeforeAndAfterAll {
  val cluster = Cluster.builder.addContactPoint("127.0.0.1").build()
  val session = cluster.connect()

  override protected def beforeAll(): Unit = {
    session.execute("DROP KEYSPACE IF EXISTS test;")
    session.execute("CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };")
    session.execute("CREATE TABLE test.kv(key text, value int, PRIMARY KEY (key));")
  }

  override protected def afterAll(): Unit = {
    session.close()
    cluster.close()
  }

  test("write > read > update > delete") {
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k1', 1);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k2', 2);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k3', 3);")
    assert(session.execute("select * from test.kv").all.size == 3)
    assert(session.execute("select value from test.kv where key = 'k3'").all.size == 1)
    assert(session.execute("update test.kv set value = 30 where key = 'k3'").all.size == 0)
    assert(session.execute("select value from test.kv where key = 'k3'").all.get(0).getInt("value") == 30)
    assert(session.execute("delete from test.kv where key = 'k3'").all.size == 0)
    assert(session.execute("select value from test.kv where key = 'k3'").all.size == 0)
  }
}