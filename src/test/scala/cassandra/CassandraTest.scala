package cassandra

import com.datastax.driver.core.Cluster
import org.scalatest.{BeforeAndAfterAll, FunSuite, Matchers}

class CassandraTest extends FunSuite with BeforeAndAfterAll with Matchers {
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
    session.execute("select * from test.kv").all.size shouldBe 3
    session.execute("select value from test.kv where key = 'k3'").all.size shouldBe 1
    session.execute("update test.kv set value = 30 where key = 'k3'").all.size shouldBe 0
    session.execute("select value from test.kv where key = 'k3'").all.get(0).getInt("value") shouldBe 30
    session.execute("delete from test.kv where key = 'k3'").all.size shouldBe 0
    session.execute("select value from test.kv where key = 'k3'").all.size shouldBe 0
  }
}