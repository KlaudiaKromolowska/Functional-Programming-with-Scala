package extraLab

object ExtraLab_ex1 {
  class MyMaybe[T](t: T, ok: Boolean = true) {
    def flatMap(fun: T => MyMaybe[T]): MyMaybe[T] = {
      if (ok) {
        fun(t)
      } else { new MyMaybe[T](t, false) }
    }

    override def toString: String = {
      if (ok) {
        t.toString
      } else { "FAILED" }
    }
  }
  def main(args: Array[String]): Unit = {
    val a = new MyMaybe(9.0)

    def fail(arg: Double) =
      new MyMaybe(0.0, false) // the false means that computation failed
    def mult(arg: Double) = {
      println("multiplying " + arg.toString); new MyMaybe(arg * 2.0)
    }

    val computationFailed =
      a.flatMap(mult _).flatMap(fail).flatMap(mult _) // HERE IS THE ESSENCE
    val computationSucceeded =
      a.flatMap(x => new MyMaybe(x * 2)).flatMap(x => new MyMaybe(x * 2))
    println(computationFailed)
    println(computationSucceeded)

    // result:
    //multiplying 9.0
    //FAILED
    //36.0
  }
}
