package lectures.part3fp

import scala.util.Random

object Sequences extends App {

//  // Seq - well defined order, can be indexed, support apply, iterator, length, reverse, concatenation, appending prepending, grouping, sorting, zipping, searching, slicing, etc.
//  val aSequence = Seq(1,3,2,4)
//  println(aSequence)
//  println(aSequence.reverse)
//  // pull out entry at this index
//  println(aSequence(2))
//  // concatenation
//  println(aSequence ++ Seq(7,5,6))
//  // sorting can only be done on types that are sortable
//  println(aSequence.sorted)

//  // Ranges
//  // excludes upper bound
//  val aRange: Seq[Int] = 1 until 10
//  aRange.foreach(println)
//
//  // includes upper bound
//  val anRange: Seq[Int] = 1 to 10
//  anRange.foreach(println)
//
//  // used in practice when you need to do things multiple times
//  (1 to 10).foreach(x => println("Hello"))
//
//  // lists
//  val aList = List(1,2,3)
//  val prepended = 42 +: aList :+ 89
//  // can also use :: for prepending
//  println(prepended)
//
//  // curried function to make a list of identical entries
//  val apples5 = List.fill(5)("apple")
//  println(apples5)
//
//  // concats all elements with something in between
//  println(apples5.mkString("-|-"))
//
//  // arrays
//  val numbers = Array(1,2,3,4)
//  // allocates space for elements without values being given (default values of some kind are given depending on data type)
//  val threeElements = Array.ofDim[String](3)
//  threeElements.foreach(println)
//
//  // mutation
//  numbers(2) = 0  // syntax sugar for numbers.update(2, 0)
//  println(numbers.mkString(" "))
//
//  // arrays and seq
//  val numbersSeq: Seq[Int] = numbers  // implicit conversion produces WrappedArray
//  println(numbersSeq)

  // vectors - default implementation for immutable sequences, effectively constant indexed read and write, good performance for large sizes
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists

  val maxRuns = 1000
  val maxCapacity = 1000000

  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle takes long
  println(getWriteTime(numbersList))
  // depth of the tree is small
  // needs to replace an entire 32-element chunk
  println(getWriteTime(numbersVector))

}
