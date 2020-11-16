object Ex1Lab4 {
  // Functions 1)
  val p1 = (x: Double) => x
  val p2 = (x: Double) => x * x
  // Function 1a)
  def pn(x: Double) = { (n: Double) =>
    math.pow(x, n)
  }
  // Function 2)
  val l1 = List(p1, p2, pn(5))
  val l2 = List(p1, p2, pn(3))

  // Function 3)
  def eval(list: List[Double => Double], value: Double): Double = {
    var temporary: Double = value
    for (arg <- list) (temporary = arg(temporary))
    temporary
  }
  // Main function
  def main(args: Array[String]): Unit = {
    println(pn(5)(5))
    println(eval(l2, 2))
  }
}
