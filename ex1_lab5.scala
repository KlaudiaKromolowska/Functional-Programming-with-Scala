object Ex1_lab5 {
  @scala.annotation.tailrec
  def filterList(list: List[String],
                 StringFilter: String => Boolean,
                 endList: List[String] = List() // make empty list
  ): List[String] = {
    if (list.isEmpty) return endList
    val nextList =
      if (StringFilter(list.head)) list.head :: endList else endList
    filterList(list.tail, StringFilter, nextList)
  }
  def main(args: Array[String]): Unit = {
    println(filterList(List("Hello", "there", "people"), _.contains('l')))
  }
}
