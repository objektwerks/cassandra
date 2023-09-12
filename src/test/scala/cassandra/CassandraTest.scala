package cassandra

import com.datastax.oss.driver.api.core.CqlSession

import java.net.InetSocketAddress

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class CassandraTest extends AnyFunSuite with Matchers:
  test("write > read > update > delete") {
    val address = new InetSocketAddress("127.0.0.1", 9042)
    val datacenter = "datacenter1"
    val session = CqlSession
      .builder()
      .addContactPoint(address)
      .withLocalDatacenter(datacenter)
      .build()
    
    session.execute("DROP KEYSPACE IF EXISTS test;")
    session.execute("CREATE KEYSPACE test WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1 };")
    session.execute("CREATE TABLE test.kv(key text, value int, PRIMARY KEY (key));")
 
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k1', 1);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k2', 2);")
    session.execute("INSERT INTO test.kv(key, value) VALUES ('k3', 3);")

    session.execute("select * from test.kv").all.size shouldBe 3
    session.execute("select value from test.kv where key = 'k3'").all.size shouldBe 1
    session.execute("update test.kv set value = 30 where key = 'k3'").all.size shouldBe 0
    session.execute("select value from test.kv where key = 'k3'").all.get(0).getInt("value") shouldBe 30
    session.execute("delete from test.kv where key = 'k3'").all.size shouldBe 0
    session.execute("select value from test.kv where key = 'k3'").all.size shouldBe 0

    session.close()
  }