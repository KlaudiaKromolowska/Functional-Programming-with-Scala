import scala.collection.mutable

object ex1 {
  class Hist(nbins: Int, min: Int, max: Int) extends Iterable[(Int, Int)] {

    var bins: mutable.Map[Int, Int] = {
      var maps = scala.collection.mutable.Map[Int, Int]()
      for (i <- Range(0, nbins)) { //od 0 do ilosci nbinsow
        val next = ((max - min) / nbins) * i //obliczamy hist
        maps += (min + next -> 0) // zapis do mapy elementu: klucz min + next, wartosc 0
      }
      maps
    }
    
    override def iterator: Iterator[(Int, Int)] = bins.iterator

    override def toString(): String = {
      "histogram min: " + min + " max: " + max + " bins content: " + bins
        .mkString(" ")
    }

    def add(everyone: Int*): Hist = {
      for (x <- everyone) {
        if (x < max && x >= min) {
          bins(x) += 1
        }
      }
      this
    }
  }
  def main(args: Array[String]): Unit = {
    val studentsAge = new Hist(nbins = 10, 20, 30)
    studentsAge
      .add(21)
      .add(19)
      .add(21)
      .add(23)
      .add(25, 26, 27, 22, 21, 19)
      .add(26)
      .add(31)
    println(studentsAge.bins.mkString(" "))
    println(studentsAge)
    println("count > 1" + studentsAge.filter(_._2 > 1).mkString(" ")) // bins that have values above the threshold
    println("age > 25 " + studentsAge.filter(_._1 > 25).mkString(" ")) // bins age > 25
    println(studentsAge.maxBy(_._2)) // bin with maximum number of students
    println(studentsAge.minBy(_._2)) // --------- minimum -----------------
    println(studentsAge.toList) //
    println(studentsAge.toArray) //
    println(studentsAge.toVector) //
    println(studentsAge.exists(_._2 == 0)) // is there age bin that is unfilled
    println(studentsAge.map(_._2)) // only bin values
    println(studentsAge.partition(_._2 == 0)) // filled & unfilled bins /

  }
}
