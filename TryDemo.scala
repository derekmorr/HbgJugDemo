import scala.util.{Failure, Try}

class User(val id: Long, val name: String, val age: Int)

class Item(val id: Long, val name: String)

object TryDemo extends App {

  def getUser(id: Long): Try[User] = Try {
    new User(id, "Derek Morr", 37)
  }

  def getItems(userId: Long): Try[List[Item]] = Try {
    throw new Exception("oops")
    List(new Item(1, "Dog Food"), new Item(2, "Dog toys"))
  }

  // imagine this is some server code
  val out = for {
    user <- getUser(1)
    items <- getItems(1)
  } yield {
    val itemNames = items map { item => item.name }
    println(s"user ${user.name} has items: $itemNames")
  }

  out recover { case ex =>
    println("HTTP 500 YOLO!")
  }

}
