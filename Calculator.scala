import scala.annotation.tailrec

object Calculator extends App {

  def calculate(program: List[Char]): Int = {
    @tailrec def helper(remaining: List[Char], accumulator: Int): Int = remaining match {
      case List()       => accumulator
      case '+' :: tail  => helper(tail, accumulator + 1)
      case '-' :: tail  => helper(tail, accumulator - 1)
      case head :: tail => helper(tail, accumulator)
    }
    helper(program, 0)
  }

  val result = calculate("++-$#+".toList) // yields 2
  println(result)
}
