package lectures.part3fp

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // higher order function (HOF)
  // common examples: map, flatMap, filter in MyList

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(...f(x))) = nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x // if function doesn't need to be applied, just return x
    else nTimes(f, n-1, f(x)) // use recursion to call function until base condition is met

//  val plusOne: Int => Int = (x: Int)  => x + 1
//  val plusOne = (x: Int) => x + 1
//  val plusOne: Int => Int = x => x + 1
  // define a simple function to pass in to HOF above
  val plusOne: Int => Int = _ + 1
  // call the HOF
  println(nTimes(plusOne, 10, 1)) // this should call plusOne 10 times => 11

  // ALTERNATE WAY TO WRITE THIS
  // RETURNS A LAMBDA INSTEAD OF THE FINAL VALUE THAT CAN LATER BE USED ON ANY PARAMETER
  // ntb(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne, 10) = x => plusOne(plusOne....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) =
    if (n <= 0) x => x
    else x => nTimesBetter(f, n-1)(f(x))

  // call it
  val plus10 = nTimesBetter(plusOne, 10) // this returns a lambda that will call function 10 times
  println(plus10(1)) // provide number to start at

  // curried functions
  val superAdder: Int => (Int => Int) = (x: Int) => (y: Int) => x + y // arrow sign is right-associative, could be written (Int => Int => Int) and parens around last 2 implied
  val add3 = superAdder(3)  // y => 3 + y - helpful if you want to define and save function(s) that you later want to call on various values
  println(add3(10)) // add3 can now be called on any number
  // can call this way as well
  println(superAdder(3)(10))

  // functions with multiple parameter lists

  // define a formatter function
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

//  /*
//    1.  Expand MyList
//        - foreach method A => Unit
//          [1,2,3].foreach(x => println(x))
//
//        - sort function ((A, A) => Int) => MyList
//          [1,2,3].sort((x, y) => y - x) => [3,2,1]
//
//        - zipWith (list, (A, A) => B) => MyList[B]
//          [1,2,3].zipWith([4,5,6], x * y) => [1 * 4, 2 * 5, 3 * 6] = [4,10,18]
//
//        - fold(start)(function) => a value
//          [1,2,3].fold(0)(x + y) = 6
//
//    2.  toCurry(f: (Int, Int) => Int) => (Int => Int => Int)
//        fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
//
//    3.  compose(f,g) => x => f(g(x))
//        andThen(f,g) => x => g(f(x))
//   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)

  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  // FunctionX
  def compose[A,B,T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A,B,C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(17))

  val simpleAdder = fromCurry(superAdder)
  println(simpleAdder(4,17))

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3

  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)

  println(composed(4))
  println(ordered(4))

}
