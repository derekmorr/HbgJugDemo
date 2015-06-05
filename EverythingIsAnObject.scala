object EverythingIsAnObject extends App {
  5 + 2

  // Java:
  // primitive (5)
  // operator (+)
  // primitive (2)

  // Scala: Object.method(Object)

  5.+(2)
  5 +(2)
  5 + 2

  val numbers = 1 to 10

  class Foo(n: Int) {
    def +(x: Int) = n + x
  }

  val four = new Foo(4)
  four + 3

  // list operations
  val a = List(1, 2, 3)
  val b = List(4, 5, 6)

  // new list, containing a followed by b
  val c = a ++ b

  // new list w/ 9 prepended to a
  val d = 9 +: a

  // new list w/ 4 appended to a
  val e = a :+ 4

  // a and b are unmodified.
  a
  b
}
