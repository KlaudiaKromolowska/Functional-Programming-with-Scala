import scala.math._

class Complex(val x: Double, val y: Double) {
  override def toString: String =
    "Re: {" + x + "} Im: {" + y + "}" // define how to print
  def +(a: Complex): Complex = new Complex(a.x + x, a.y + y) //??????????
  def -(a: Complex): Complex = new Complex(a.x - x, a.y - y)
  def r: Double = hypot(x, y) // sqrt(x*x+y*y)
  def angle: Double = atan(y / x) // arcustangens
}

object Complex {
  def apply(x: Double, y: Double): Complex = new Complex(x, y)
  def polar(r: Double, angle: Double): Complex =
    new Complex(r * sin(angle), r * cos(angle))
  def main(args: Array[String]): Unit = {
    val x = Complex(1, 2)
    val y = Complex(3, 2)
    println("x " + x + " y " + y + " x+y " + (x + y) + " x-y " + (x - y))
    val f = Complex.polar(r = 3, angle = math.Pi)
    println(f)
    println("|x| " + x.r + " angle " + x.angle)
  }
  /*//Expected result:
  x Re:{1.0} Im:{2.0} y Re:{3.0} Im:{2.0} x+y Re:{4.0} Im:{4.0} x-y Re:{4.0} Im:{0.0}
  Re:{3.6739403974420594E-16} Im:{-3.0}
  |x| 2.23606797749979 angle 1.1071487177940904*/

}
