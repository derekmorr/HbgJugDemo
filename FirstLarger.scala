object FirstLarger extends App {

  val numbers = List(3, 4, 7, 9, 8, 1)

  // imperativer version w/ looping.
  def firstLarger1(data: List[Int], threshold: Int): Option[Int] = {

    var result: Option[Int] = None
    val iter = data.iterator

    while(iter.hasNext && result == None) {
      val i = iter.next
      if (i > threshold) result = Option(i)
    }

    result
  }

  // first take on a functional version.
  // no mutable variables, but still imperative.
  def firstLarger2(data: List[Int], threshold: Int): Option[Int] = {
    if (data == Nil) {
      None
    } else {
      val head = data.head
      if (head > threshold) {
        Option(head)
      } else {
        firstLarger2(data.tail, threshold)
      }
    }
  }

  // pattern matching version
  def firstLarger3(data: List[Int], threshold: Int): Option[Int] = data match {
    case Nil => None
    case head :: tail if head > threshold => Option(head)
    case head :: tail => firstLarger3(tail, threshold)
  }

  // now, pass in an arbitrary predicate rather than hard-coding it
  def findFirstInt(data: List[Int],
                   predicate: Int => Boolean): Option[Int] = data match {
    case Nil => None
    case head :: tail if predicate(head) => Option(head)
    case head :: tail => findFirstInt(tail, predicate)
  }

  // now, use a generic type parameter, T, so let this work with any data type.
  def findFirst[T](data: List[T],
                predicate: T => Boolean): Option[T] = data match {
    case Nil => None
    case head :: tail if predicate(head) => Option(head)
    case head :: tail => findFirst(tail, predicate)
  }

  val words = List("dog", "pony", "car", "radar", "fish")

  val result1 = findFirst(words, { w: String => w == w.reverse} )
  val result2 = Some("howdy")

  // various ways to use Option
  result1 map { r1 =>
    result2 map { r2 =>
      println(s"$r1 $r2")
    }
  }

  for {
    r1 <- result1
    r2 <- result2
  } yield {
    println(s"$r1 $r2")
  }
}
