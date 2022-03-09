package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  // this function gets the time stamp once and uses that same value throughout the rest of the function
  calledByValue(System.nanoTime())
  // this function gets the time stamp each time the variable is called within the function
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  // infinite loops since there is no base condition to exit the recursion
  // printFirst(infinite(), 34)

  // compare this to passing it in by name
  printFirst(34, infinite())
  // since it is passed in by name, it is not evaluated up front, rather it is only evaluated when it is needed
  // it is never needed in the function, so it never is evaluated and never causes an issue

}
