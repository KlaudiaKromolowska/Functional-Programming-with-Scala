object ex1 {
  class A {
    override def toString: String = "A"
  }
  class B(val x: Int) extends A {
    override def toString: String = "B:" + x.toString
  }
  class C(x: Int) extends B(x) {
    override def toString: String = "C:" + x.toString
  }
  case class TwistedMonoPair[+T](val x: (T, T) {
    def replace[A >: T](i: Int)(n: A): TwistedMonoPair[A] = {
      if (i == 0) TwistedMonoPair[A](x.copy(_1=n))
      else TwistedMonoPair[A](x.copy(_2=n))
    }
    def apply(i: Int): T = {
      if (i == 0) x._1 else x._2
    }
  }y

  def main(args: Array[String]): Unit = {
    val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)
    println(a(0))
    println(a(1))
    println(a)
    val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new B(77)) // covariantnes
    println(b)
    //val c: TwistedMonoPair[A] = new TwistedMonoPair[B](new B(9), new A)  // should not compile, covariantness
    val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair
    println(d1)
    val tA: TwistedMonoPair[A] = d1
    println(tA)
    //val tB : TwistedMonoPair[B] = d1 // can not compile
    val d2 = b.replace(1)(new A) // as above, but replaced is the second el
    println(d2)
  }
}
