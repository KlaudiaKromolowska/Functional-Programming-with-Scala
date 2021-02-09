object ex2 {
  class stream(x: String) {
    override def toString: String = "List: " + x
  }

  object stream {
    def apply(list: List[Any]): stream =
      new stream(rec(list))

    @scala.annotation.tailrec
    def rec(list: List[Any], res: String = ""): String = {
      list match {
        case Nil     => res
        case x :: xs => rec(xs, res + matching(x) + ", ")
      }
    }

    def matching(value: Any): String = {
      value match {
        case x: String => "String(" + x + ")"
        case x: Int    => "Int(" + x + ")"
        case x: Double => "Double(" + x + ")"
        case x: Float  => "Float(" + x + ")"
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val l = List(1, "hello", 2.56, 0x45, "key")
    val streamed = stream(l)
    println(streamed)
  }
}
