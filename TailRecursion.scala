import scala.annotation.tailrec

object TailRecursion extends App {

  // this is a simple implementation of map() for lists
  // if we have an empty list, return an empty list
  // if we have a non-empty list, apply the mapping function to the head
  // and recursively call map() for the tail.
  // this is not tail-recursive, so it overflows the stack for large lists
  def sadmap(list: List[Int], func: Int => Int): List[Int] = list match {
    case Nil => Nil
    case head :: tail => func(head) :: map(tail, func)
  }

  // this is a better version of map()
  // it uses two lists, one of elements is hasn't processed, remaining, and
  // one of elements it has processed, accumulator.
  // it's tail recursive, so it works for large lists b/c the Scala compiler
  // effectively rewrites it as a loop.
  def map(list: List[Int], func: Int => Int): List[Int] = {

    @tailrec def helper(remaining: List[Int],
                        accumulator: List[Int]): List[Int] = remaining match {
      case Nil => accumulator.reverse
      case head :: tail => {
        def newAcc = func(head) +: accumulator
        helper(tail, newAcc)
      }
    }

    helper(list, Nil)

  }

  val numbers = (0 to 100000) toList

  map(numbers, { x: Int => x * 2} )
}
