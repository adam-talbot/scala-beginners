package lectures.part3fp

object WhatsAFunction extends App {

  // DREAM: use functions as first class elements (want to work with functions as we do with any other value)
  // problem: oop (everything is an instance of an object)

  // create an instance of the trait, override the apply method and this now looks like a function
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Scala supports many function types out-of-the-box (OOTB)
  // there are ~23=2 function types available
  // function types = Function1[A, B] (takes one parameter and returns one result)
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: /* Function2[Int, Int, Int] */ ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // Function types Function2[A, B, R] === (A,B) => R

  // ALL SCALA FUNCTIONS ARE OBJECTS

  /*
    1.  a function which takes 2 strings and concatenates them
    2.  transform the MyPredicate and MyTransformer into function types
    3.  define a function which takes an int and returns another function which takes an int and returns an int
        - what's the type of this function
        - how to do it
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }
  println(concatenator("Hello ", "Scala"))

  // Function1[Int, Function1[Int, Int]]
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  // 2 step call
  val adder3 = superAdder(3) // call the first function, this returns and int and another function
  println(adder3(4)) // call the second function to get to final result by passing another param
  println(superAdder(3)(4)) // curried function

}

// this is the closest that you can get to a function in oop world
trait MyFunction[A, B] {
  def apply(element: A): B

}
