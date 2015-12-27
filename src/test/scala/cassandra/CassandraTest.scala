package cassandra

import com.datastax.driver.core.Cluster
import org.scalatest.FunSuite

class CassandraTest extends FunSuite {
  val cluster = Cluster.builder.addContactPoint("127.0.0.1").build()
  val session = cluster.connect()

  test("connect") {
    assert(!session.isClosed)
  }
}