import scala.beans.BeanProperty

object ScalaBasics {

  // Scala has type inference
  val x = "Hello"
  val y = 7
  val price = 16.75

  def sum(a: Int, b: Int) = { a + b }

  // List[String]
  val names = List("Ann", "Bob", "Charles")

  // Map[Int, String]
  val people = Map(
    1 -> "Ann",
    2 -> "Bob",
    3 -> "Charles")

  class Car(@BeanProperty val yearConstructed: Int,
            @BeanProperty var mileage: Int)

  val jetta = new Car(1999, 150000)

  // scala getters and setters look like native field access,
  // but are actually method calls
  jetta.mileage
  jetta.mileage = 165000
  jetta.mileage

  // JavaBean-style getters and setters are generated with the
  // @BeanProperty annotation on the fields.
  jetta.getMileage()
  jetta.setMileage(4000)
  jetta.mileage

}
