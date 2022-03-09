package lectures.part1basics

object ValuesVariableTypes extends App{

  // define a variable in scala

  val x: Int = 42
  println(x)

  // vals are immutable, intermediate computations to use later

  // compiler can infer types, don't always need to declare them, but can if you want

  val aString: String = "hello"; val anotherString = "goodbye"

  // looks like you must use double quotes in scala
  // ;s are not usually necessary since you should be writing things on new lines, but you can write on same line and separate expressions using ;

  val penultimateString = "greetings"
  val lastString = "farewell"

  // this is the recommended style instead of using ;s

  // lets declare some different variable types

  val aBool: Boolean = false
  val aChar: Char = 'a'
  val aInt: Int = x
  val aShort: Short = 4613
  // 2 bytes max
  val aLong: Long = 546484654684654L
  // 4 bytes max
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // aDouble = 4.25
  // does not compile, immutable

  // variables
  var aVariable: Int = 4
  aVariable = 5 // called side effects, allow us to see what program is doing, will talk more about this
  // this compiles fine since vars are mutable

}
