object ex2 {
  def main(args: Array[String]): Unit = {
    val people = List(
      ("John", "Doe", 23, "male"),
      ("Joan", "Doe", 23, "female"),
      ("Steve", "Jenkins", 24, "male"),
      ("Eva", "Robinson", 25, "female"),
      ("Ben", "Who", 22, "male"),
      ("Janet", "Reed", 21, "female"),
      ("Rob", "Jenkins", 26, "male"),
      ("Ella", "Dawson", 27, "female")
    )

    //female and male
    val femaleOrMale = people.partition(_._4 == "female")
    print("List of female: ")
    println(femaleOrMale._1)
    print("List of male: ")
    println(femaleOrMale._2)

    // >23
    print("People older than 23: ")
    val moreThan23: List[String] = people.filter(_._3 > 23).map(x => x._1)
    println(moreThan23)

    // Joe or Rob
    print("There are some people of names Joe or Rob,. True or false? ")
    val joeOrRob = people.count(men => men._1 == "Joe" | men._1 == "Rob")
    println(joeOrRob > 0)

    //number of female male
    print("Number of female is equal to number of male. True or false? ")
    println(femaleOrMale._1.length == femaleOrMale._2.length)
  }
}
