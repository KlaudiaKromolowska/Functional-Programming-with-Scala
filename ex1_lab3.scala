object Ex1Lab3 {
  def print2D(x: Array[Array[Int]]) = {
    for (i <- 0 until 4) {
      print("| ")
      for (j <- 0 until 5) {
        print(x(i)(j) + " ")
      }
      println("|")
    }
  }

  def sumRowCol(x: Array[Array[Int]]): Unit = {
    val list1: Array[Int] = new Array[Int](5)
    for (i <- 0 until 4) {
      list1(i) = x(i).sum
      print(list1(i) + ", ")
    }
    println()
    val transp = x.transpose
    val list2: Array[Int] = new Array[Int](4)
    for (i <- 0 until 4) {
      list2(i) = transp(i).sum
      print(list2(i) + ", ")
    }
    println()
  }

  def transpo(x: Array[Array[Int]]): Unit = {
    val x2 = x.transpose
    for (i <- 0 until 5) {
      print("| ")
      for (j <- 0 until 4) {
        print(x2(i)(j) + " ")
      }
      println("|")
    }
  }

  def maxArray(array1: Array[Array[Int]], array2: Array[Array[Int]]): Unit = {
    val finalArray = Array.ofDim[Int](array1.length, array1(0).length)
    for (i <- 0 until array1.length) {
      for (j <- 0 until array1(0).length) {
        finalArray(i)(j) = Math.max(array1(i)(j), array2(i)(j))
      }
    }
    print2D(finalArray)
  }

  def main(args: Array[String]): Unit = {
    val x = Array.ofDim[Int](4, 5);
    for (i <- 0 until 4; j <- 0 until 5) x(i)(j) = i + j
    print2D(x)
    sumRowCol(x)
    transpo(x)
    val y = Array.ofDim[Int](4, 5);
    for (i <- 0 until 4; j <- 0 until 5) x(i)(j) = i + j / 2 + 3
    maxArray(x, y)
  }
}
