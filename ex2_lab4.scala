object Ex2Lab4 {
  @scala.annotation.tailrec
  def sumFrac(eps: Double): Double = {
    def add(num: Double, sum: Double): Double = {
      if (num < eps) return sum
      add(num / 2.0, sum + num)
    }
    add(1.0, 0)
  }

  def main(args: Array[String]): Unit = {
    val sum1 = sumFrac(1e-3)
    val sum2 = sumFrac(1e-9)
    println(sum1)
    println(sum2)
  }
}
