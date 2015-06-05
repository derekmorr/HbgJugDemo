sealed trait Data
case class Item(value: Int, flag: Boolean) extends Data
case class MultiItem(values: List[Int], flag: Boolean) extends Data

object SealedExample extends App {

  // sealed traits let the compiler perform exhaustiveness checking
  // b/c Data is sealed, the compiler knows there are only two types:
  // Item and MultItem. Below, we only handle one of those cases, so
  // the compiler will complain.
  def dataProcessor(data: Data) = data match {
    case Item(value, true) => println("you've got one item")
  }
}
