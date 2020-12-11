object ex11 {
  object Result {
    def unapply(str: String): Option[(Double, Double)] = {
      val ab = str.split("[-+*/]")
      val a = ab(0).toDouble
      val b = ab(1).toDouble
      Some(a, b)
    }
  }
  def evalEx(str: String): Double = {
    val Result(a, b) = str
    str match {
      case s: String if s.contains("+") => a + b
      case s: String if s.contains("-") => a - b
      case s: String if s.contains("/") => a / b
      case s: String if s.contains("*") => a * b
    }
  }
  def main(args: Array[String]): Unit = {
    val Result(a, b) = "2 + 6.5";
    println(evalEx("2 +5"))
    println(evalEx("2- 125"))
    println(evalEx("2*5"))
    println(evalEx("25 / 5.9"))
  }
}
