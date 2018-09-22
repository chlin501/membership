package membership

import org.joda.time.DateTime
import org.joda.time.DateTimeZone

case class Address(hostname: String = "localhost", port: Int = 1234) {

  require(null != hostname && !"".equals(hostname), "'hostname' value is empty!")

  require(0 < port && 65536 > port, s"Invalid port value: $port!")

}

object Node {
  sealed trait State
  case object Alive extends State
  case object Suspect extends State
  case object Dead extends State
}

case class Node(
  name: String = "", address: Address = Address(), incarnation: Int = 0, 
  state: Node.State = Node.Alive, lastState: Option[DateTime] = None
)
