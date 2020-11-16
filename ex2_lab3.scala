import scala.math.Pi

object Ex2Lab3 {
  def pi: Double = Pi

  def pi(arg: Double): Double = Pi * arg

  def repN(i: Int, expr: Int => Int, inv: Int): Int = {
    if (i == 0) inv else repN(i - 1, expr, expr(inv))
  }

  def main(args: Array[String]): Unit = {
    println(pi)
    println(pi(pi))
    println(pi(pi(pi)))
    println(repN(5, (x: Int) => 2 * x, 1))
  }
}
