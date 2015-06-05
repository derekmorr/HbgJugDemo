object PatternMatchingExamples extends App {

  // in the simple case, it's a lot like a switch statement.
  // except it's an expression, not a statement.
  def labelQuantity(qty: Int): String = qty match {
    case 0 => "None"
    case 1 => "One"
    case 2 => "A pair"
    case 3 => "A few"
    case _ => "A lot"
  }

  labelQuantity(2)
  labelQuantity(4)


  // we can mix and match types
  // "Any" is roughly equivalent to java.lang.Object
  def mixAndMatch(x: Any): Any = x match {
    case 1 => "one"
    case false => Nil
    case Math.PI => List(1, 2, 3)
    case "foo" => -3
  }

  // we can bind variables and extra values
  def whatIsIt(x: Any): String = x match {
    case i: Int => s"it's an int $i"
    case s: String => s"it's a string! $s"
    case b: Boolean => s"it's a boolean $b"
    case _ => "unknown"
  }

  // we can match on more complex patterns, like head :: tail
  def printList(list: List[Int]): Unit = list match {
    case Nil => println("Nil")
    case head :: tail => {
      println(head)
      printList(tail)
    }
  }

  printList(List(1, 2, 3))

}
