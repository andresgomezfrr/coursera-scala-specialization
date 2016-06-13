package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    def isBrackets(c: Char): Boolean = c == '(' || c == ')'
    def withCount(c: Char): Int = if (c == '(') 1 else -1
    def checkCorrectBrackets(chars: List[Int], count: Int): Boolean = count match {
      case x if x < 0 => false
      case x if chars.isEmpty => x == 0
      case x => checkCorrectBrackets(chars.tail, x + chars.head)
    }

    checkCorrectBrackets(chars.filter(isBrackets).map(withCount), 0)

    // Other way not recursive:
    //    def checkBrackets(o: Int, n: Int): Int = if (o < 0) -1 else o + n
    //    chars.filter(isBrackets).map(withCount).reduce[Int](checkBrackets) >= 0
  }


  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    def counting(currentMoney: Int, coins: List[Int]): Int = currentMoney match {
      case x if x < 0 || coins.isEmpty => 0
      case x if x == 0 => 1
      case _ => counting(currentMoney, coins.tail) + counting(currentMoney - coins.head, coins)
    }

    counting(money, coins.sorted.reverse)
  }

}
