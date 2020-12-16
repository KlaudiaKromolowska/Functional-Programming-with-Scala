object ex1 {
  trait Food {
    override def toString: String = "Food"
  }
  trait Plants extends Food {
    override def toString: String = "Plants"
  }
  class Carrot extends Plants {
    override def toString: String = "Carrot"
  }
  trait Meat extends Food {
    override def toString: String = "Meat "
  }

  abstract class Animal {
    type WhatToEat <: Food
    val howEat: String
    def eat(food: WhatToEat): Unit = {
      println(this + howEat + food)
    }
    override def toString: String = "Animal"
  }

  class Rabbit extends Animal with Meat {
    override val howEat = " crunches the "
    override type WhatToEat = Plants
  }
  class Wolf extends Animal {
    override val howEat = " tears apart the "
    override type WhatToEat = Meat
  }
  def main(args: Array[String]): Unit = {
    val c: Plants = new Carrot
    val r = new Rabbit
    val w = new Wolf
    val a: Animal = r
    val f: Food = r
    // this two should compile and run w/o problems
    r.eat(c)
    w.eat(r)
    // whereas these should not compile
    // r.eat(r)
    // w.eat(c)
  }
}
