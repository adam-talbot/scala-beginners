package lectures.part3fp

object AnonymousFunctions extends App {

  // anonymous functions (LAMBDAs)

  // one param
//  val doubler: Int => Int = (x: Int) => x * 2 // param and return types (func type also) implementation
   val doubler: Int => Int = x => x * 2 // this has enough for compiler to know what to do
  //  val doubler = x => x * 2 // this one will not run, compiler needs param type somewhere
  // use the _ notation
  // val doubler: Int => Int = _ * 2

//  println(doubler(2))

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a, b) => a + b // one way
//  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b // most explicit way, redundant
//  val adder = (a: Int, b: Int) => a + b // another way
  // val adder = (a, b) => a + b // this one will not run, compiler needs param type somewhere
//  val adder: (Int, Int) => Int = _ + _ // underscore shorthand
//
//  println(adder(1,2))

  // no params
  val justDoSomething: () => Int = () => 3 // takes no params and just returns a 3

  // careful
//  println(justDoSomething) // function itself (function definition)
//  println(justDoSomething()) // call

//  // curly braces with lambdas

//  // most explicit, defining param type twice
//  val stringToInt: String => Int = { (str: String) =>
//    str.toInt
//  }
//  // just defining param type(s), return type inferred
//  val stringToInt = { (str: String) =>
//    str.toInt
//  }
  // defining param and return with function type
  val stringToInt: String => Int = { str =>
    str.toInt
  }

  //println(stringToInt("23"))

  // MOAR syntactic sugar
//  val niceIncrementer: Int => Int = (x: Int) + 1 // full, traditional syntax
  // shorthand using func type and underscores
  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a,b) => a + b

//  /*
//    1.  MyList: replace all FunctionX calls with lambdas
//    2.  Rewrite the "special" adder as an anonymous function
//   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}
