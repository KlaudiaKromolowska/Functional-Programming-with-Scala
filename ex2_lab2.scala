import scala.math.sqrt
import scala.util.Random

object Ex2Lab2 {
  def main(args: Array[String]): Unit = {
    val generator = new Random()
    val n = 10000000
    var insideN: Int = 0
    for (i <- 1 to n) {
      val (x, y) = (generator.nextDouble, generator.nextDouble)
      val distance = sqrt(x * x + y * y)
      if (distance < 1) {
        insideN += 1
      }
    }
    println(4.0 * insideN.toDouble / n)
  }
}
