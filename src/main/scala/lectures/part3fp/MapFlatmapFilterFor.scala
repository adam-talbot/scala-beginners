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
//  val toPair = (x: Int) => List(x, x+1) // takes an int and converts to a list of int and int + 1]
//  println(toPair(1))
//  println(list.flatMap(toPair)) // concatenates the results of the implementation of the func on each element into a single list

  // print all combinations between two lists
  // List("a1", "a2"... "d4")
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')

//  // using for loop
//  for (n <- numbers) {
//    // println(n)
//    for (c <- chars) {
//      println(n.toString + c)
//    }
//  }

//  // concatenate num and char for each num and then map to lists
//  val listsOfCombos = numbers.map(n => chars.map(c => c + n.toString))
//  // use flatmap to concatenate all of these lists
//  val combinations = numbers.flatMap(n => chars.map(c => c + n.toString))
//  println(listsOfCombos)
//  println(combinations)
//
//  // add another list to concat (flatmap for outside collections and map for innermost collection)
  val colors = List("black", "white")
//  val combinationsColors = numbers.flatMap(n => chars.flatMap(c => colors.map(color => n.toString + c + "-"  + color)))
//  println(combinationsColors)
//
//  // "iterating" with a filter added
//  val combinationsFilter = numbers.filter(_ % 2 == 0).flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
//  println(combinationsFilter)

  // foreach (takes each element from a collection and performs something on it)
  list.foreach(println)

  // for-comprehensions (a way to rewrite above nested flatMaps and maps in a more readable format)
  // compiled the same as above just much more readable, preferred in practice
  // without filter
  val forCombinations = for {
    n <- numbers
    c <- chars
    color <- colors
  } yield c + n.toString + "-" + color
  println(forCombinations)
  // with filter
  val forCombinationsFilter = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinationsFilter)

  // can also have side effects, this is identical to for each above
  for {
    n <- numbers
  } println(n)

  // syntax overload
  val syntax = list.map { x =>
    x * 2
  }
  // same as
  val normal = list.map(x => x * 2)
  val normalshort = list.map(_ * 2)

  println(syntax)
  println(normal)
  println(normalshort)
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
