import scala.math.sqrt
object Main {

  def condition(y: Int): Boolean = {
    sqrt(y) - sqrt(y).toInt != 0
  }

  def notSquare(n: Int): Unit = {
    val list: List[Int] = List.range(1, n).filter(condition)
    println(list)
  }

  def main(args: Array[String]): Unit = {
    args.length match {
      case 0 => notSquare(50)
      case _ => {
        val x = args(0).toInt
        notSquare(x)
      }
    }
  }
}
