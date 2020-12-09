object ex2 {
  case class Company(str: String, coun: String)

  def getCompanies(data: List[Any]): List[Company] = {
    filter(data.map {
      case x: Map[String, String] if x contains "origin" =>
        Company(x("company"), x("origin"))
      case _ => Nil
    })
  }
  def filter(list: List[Any]): List[Company] =
    list.filter(_.isInstanceOf[Company])

  def main(args: Array[String]): Unit = {
    val data = List(
      Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),
      Map("company" -> "ABB", "origin" -> "Sweden"),
      Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),
      Map("company" -> "F4", "origin" -> "Poland"),
      List("Cos", "innego"),
      Map("company" -> "Salina Bochnia", "origin" -> "Poland"),
      Map("company" -> "AGH", "origin" -> "Poland"),
      Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
    )
    println(getCompanies(data))
  }
}
