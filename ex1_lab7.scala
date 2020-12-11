object ex11 {
  implicit class Multipl(x: Int) {
    def *(f: String): String = {
      def loop(x: Int): String = {
        if (x <= 0) return f
        f + loop(x - 1)
      }
      loop(x)
    }
  }
  implicit class Slash(x: String) {
    def /(c: Char): String = "List(" + x.split(c).mkString(", ") + ")"
  }
  implicit class Or(x: String) {
    def |(str: String): String = x + str.trim + x
  }

  def main(args: Array[String]): Unit = {
    val r = 4 * "ala"
    println(r)
    println("ala ma kota" / ' ') // str split
    println("+" | "     hello   " + "+") // rm spaces
  }
}
