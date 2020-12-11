object ex1 {
  class Car(var x: Int, var y: Int){
    override def toString = "Car - x: " + x.toString + ", y:" + y.toString
    def setX(xS: Int) {x = xS}
    def setY(yS: Int) {y = yS}
    def getX(): Int = x
    def getY(): Int = y
  }

  class Horse(var position: (Int, Int)){
    val x = position._1
    val y = position._2
    override def toString = "Horse - x: " + x.toString + ", y:" + y.toString
    def setX(xS: Int) {position = (xS, y)}
    def setY(yS: Int) {position = (x, yS)}
    def getX(): Int = x
    def getY(): Int = y
  }

  trait IntRichMoves{
    def setX(x: Int)
    def setY(y: Int)
    def getX(): Int
    def getY(): Int
    def up(by: Int = 1) {setY(getY() + by)}
    def down(by: Int = 1) {setY(getY() - by)}
    def left(by: Int = 1) {setX(getX() - by)}
    def right(by: Int = 1) {setX(getX() + by)}
    def zero() {
      setX(0)
      setY(0)
    }
    def here(a: IntRichMoves) {
      setX(a.getX())
      setY(a.getY())
    }
  }

  def main(args: Array[String]): Unit = {

    val car1 = new Car(0, 0)
    println(car1)
    val car2 = new Car(1, 0)
    println(car2)

    val betterCar = new Car(0, 0) with IntRichMoves
    println(betterCar)
    betterCar.up()
    println(betterCar)
    betterCar.right(3)
    println(betterCar)
    betterCar.down(5)
    println(betterCar)
    betterCar.left(5)
    println(betterCar)

    val runner = new Horse((1, 1)) with IntRichMoves
    println(runner)
    runner.here(betterCar)
    println(runner)
    runner.zero()
    println(runner)
  }
}
