package lectures.part1basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  // normal math order of operations
  // + - * / & | ^ << >> >>> (right shift with zero extension)

  // relations expressions
  println(1 == x)
  // == != < > <= >=

  // negators
  println(!(1 == x))
  // ! $$ || (unary vs binary operators, binary act on 2 booleans and return a single boolean)

  var aVariable = 2
  aVariable += 3 // also works with -= *= /=
  println(aVariable)

  // instructions (DO) vs expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3 // if expression, gives back a value, not a boolean
  println(aConditionedValue)
  // can print this to the consule just like any other expression
  println(if(aCondition) 5 else 3)

  // loops, not encouraged in scala, only return side effects
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN, LOOPS LIKE THIS SHOULD ONLY BE USED IN IMPERATIVE PROGRAMMING, NOT IN SCALA

  // Everything in scala is an expression (only definitions are not expressions)

  val aWeirdValue = (aVariable = 3) // Unit == void (or none type in Python)
  print(aWeirdValue)
  // the only possible value for a unit type is () which is void type

  // side effects in scala: println(), whiles, reassigning of vars

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye"
  }
  // this is an expression, value is the last expression contained within
  // have their own definitions of variables inside the code block (local scope) not visible outside

  // val anotherValue = z + 1
  // not possible, z not defined in this global scope

  // 1. difference between "hello world" and println("hello world")?
  // one will return a string while the other will return a unit or none type
  // 2. what is the value of:
  val someValue = {
    2 < 3
  }
 // true
 println(someValue)
 val someOtherValue = {
   if(someValue) 239 else 986
   42
 }
 // 42
 println(someOtherValue)

}
