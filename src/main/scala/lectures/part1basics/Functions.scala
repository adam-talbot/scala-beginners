package lectures.part1basics

object Functions extends App {

  // define a function to learn syntax
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }
  // don't need to specify return type of function, compiler will figure it out

  // call the function
  println(aFunction("hello", 3)) // this is also an expression

  def aParameterlessFunc(): Int = 42
  println(aParameterlessFunc())
//  println(aParameterlessFunc) // this could be called in scala 2, not in 3 (which I am running here)
//  could be called in 3 if defined without parens

  // loops in a functional language
  // use a function instead of the loop
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  // need to define return type of recursive functions

  println(aRepeatedFunction("hello", 3))

  // when you need loops in a functional language (like scala) use recursion

  // functions can return unit type
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

//  // can use code blocks do define outside function
//  def aBigFunction(n: Int): Int {
//    def aSmallerFunction(a: Int, b: Int): Int = a + b
//    aSmallerFunction(n, n-1) // this is now the return value of the outside function
//  }

  /*
  1. a greeting function (name, age) = "Hi, my name is $name and I am $age years old."
  2. factorial function 1 * 2 * 3 ... n
  3. fibonacci function
  4. tests if number is prime
   */

  def greeting(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old."

  println(greeting("Adam", 28))

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * (factorial(n-1))
  }

  println(factorial(3))

  def fibonacci(n: Int): Int =
    if (n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)

  println(fibonacci(8))
  // 1 1 2 3 5 8 13 21

  // needs an auxiliary function
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(22))
}
