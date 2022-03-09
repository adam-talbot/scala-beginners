package lectures.part1basics

object DefaultArgs extends App {

  // factorial with tail recursion
  // this is actually a simpler version than the one we wrote in the previous lecture
  def fact(n: Int, acc: Int): Int =
    if (n <= 1) acc
    else fact(n-1, n * acc)

  println(fact(5, 1))

  // the default value for the acc is always going to be 1 for this function
  // we want to start at 1 multiply by each int going up until we reach n

  // lets set a default parameter
  def factdef(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else factdef(n-1, n * acc)

  println(factdef(5))
  // you can define the parameter here if you wish, but it is optional

  // explore some potential issues that could arise with default args
  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")

  // savePicture(800)
  // this will confuse the compiler since it is expecting args in order in func definition
  /*
  SOLUTION:
  1. always pass in leading arg
  savePicture("jpg", 800)
  2. name the arguments when you call the func
  savePicture(width=800)
  */

  // you can also rearrange the order of the params as long as you name them
  savePicture(width=800, format="png", height=1200)

}
