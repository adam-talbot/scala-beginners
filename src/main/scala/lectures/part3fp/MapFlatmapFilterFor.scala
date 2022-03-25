package lectures.part3fp

object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)
//  println(list)
//  println(list.head) // head is first element
//  println(list.tail) // tail is the rest

  // map - applies lambda function to each element of list
//  println(list.map(_ + 1))
//  println(list.map(_ + " is a number"))

  // filter - produces a new list with just entries that meet lambda condition
//  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1) // takes an int and converts to a list of int and int + 1
//  println(list.flatMap(toPair)) // concatenates the results of the implementation of the func on each element into a single list

  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

//  val colors = List("black", "white")
//
//  // List("a1", "a2"... "d4")
//
//  // "iterating"
//  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
//  println(combinations)
//
//
//  // foreach
//  list.foreach(println)
//
//  // for-comprehensions
//  val forCombinations = for {
//    n <- numbers if n % 2 == 0
//    c <- chars
//    color <- colors
//  } yield "" + c + n + "-" + color
//  println(forCombinations)
//
//  for {
//    n <- numbers
//  } println(n)
//
//  // syntax overload
//  list.map { x =>
//    x * 2
//  }
//
//  /*
//    1.  MyList supports for comprehensions?
//        map(f: A => B) => MyList[B]
//        filter(p: A => Boolean) => MyList[A]
//        flatMap(f: A => MyList[B]) => MyList[B]
//    2.  A small collection of at most ONE element - Maybe[+T]
//        - map, flatMap, filter
//   */

}
