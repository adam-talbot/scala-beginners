package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  // let's take a look at how the stack works in recursive programming
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * (factorial(n-1))
      println("Computed factorial of " + n)

      result
    }
  }

  // take a look at a small example
  // println(factorial(10))
  // works for this case, but is storing all calls on local stack, has size limitation

  // try for larger number
  // println(factorial(5000))
  // this causes stack overflow error, fills the stack

  // how do we overcome this? have to use helper function and compute differently
  def anotherFactorial(n: Int): BigInt = {
    // tell compiler that this function is supposed to be tail recursive, it really not, warn me
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }

  // now it works, number is huge
  // println(anotherFactorial(5000))
  // THIS ONE WORKS BECAUSE IT IS NOT COMPUTING THE FACTORIAL EACH TIME AND MULTIPLYING IT BY NEXT NUMBER, IT DOES IT ALL IN ONE COMPUTATION

  // WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /*
  EXERCISES
  1. Concatenate a string n times
  2. isPrime function that is tail recursive
  3. Fibonacci function that is tail recursive

  HINTS:
  - use accumulators
  - you will need as many accumulators as you have recursive function calls
  */

  // my attempt, worked but his is simpler
  def concatStringRec(s: String, n: Int): String = {
    // create helper function with accumulator
    @tailrec
    def concatStringHelper(x: Int, accumulator: String): String =
      if (x <= 0) accumulator
      else concatStringHelper(x - 1, s + accumulator)
    // call and return final result of helper function
    concatStringHelper(n, "")
  }

  println(concatStringRec("hello", 4))

  // his version, works the same way but doesn't require nested function
  @tailrec
  def concatTailrec(s: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatTailrec(s, n-1, s + accumulator)

  println(concatTailrec("hello", 4, ""))

  // prime with tail recursion, his version
  def isPrime(n: Int): Boolean = {
    // this one will require a helper function in general and we will just make that one tail recursive
    @tailrec
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean =
      // since our accumulator is just checking status, as soon as false, we can end program
      if (!isStillPrime) false
      // base case remains the same, if the divisor gets down to 1, the number is prime
      else if (t <= 1) true
      // move logical evaluations into the recursive function call
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime)

    isPrimeTailrec(n / 2, true)
  }

  println(isPrime(29))
  println(isPrime(22))

  // fib
  // 1 1 2 3 5 8 13 21 34 55 ...
  // the purpose of the function is to enter an index and get the corresponding number in the fib sequence of numbers
  // e.g. 1 : 1,  2 : 1, 3 : 2, 4 : 3
  def fibonacci(n: Int): Int = {

    // auxiliary function needed here as well
    // we need two accumulators here since there are two recursive calls for this function to get values for n-1 (last) and n-2 (nextToLast)
    // i is our "counter" here and represents the index of the fibonacci number starting at 1
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int =
      // when i reaches our desired index, we want to pull out the fib number (this is our base case here)
      // the fib number will be stored in last
      // I think we could also use i >= n here, but I don't think there would ever be a scenario when i would be greater than n
      if (i == n) last
      // general case
      // increase i, sum n-1 and n-2 and store in last, save previous last as nextToLast
      else fiboTailrec(i + 1, last + nextToLast, last)

    // initialize it, fib numbers for index 1 and 2 are both 1
    if (n <= 2) 1
    // if n > 2, call the function starting at index 2 and going up from there until desired index
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacci(10))

}
