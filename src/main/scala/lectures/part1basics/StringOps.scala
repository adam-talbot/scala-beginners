package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // returns the char at that index, strings are 0 indexed
  println(str.charAt(2))
  // substring(inclusive, exclusive)
  println(str.substring(7, 11))
  // split on specified delimiter
  // convert to list to make array readable
  println(str.split(" ").toList)
  // check for start
  println(str.startsWith("Hello"))
  // replace
  println(str.replace(" ", "-"))
  // lower
  println(str.toLowerCase())
  // len
  println(str.length)
  // these are all the same string methods as Java since Scala has access to this class from Java (built on JVM)

  // SCALA-SPECIFIC UTILITIES
  val aNumberString = "2"
  //.toInt changes type
  val aNumber = aNumberString.toInt
  // prepending and appending
  println('a' +: aNumberString :+ 'z')
  // reverse
  println(str.reverse)
  // list-like methods
  // take first 2 chars
  println(str.take(2))

  // S-interpolators (scala specific)
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  // at least two charcters total and 2 decimal precision
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw interpolator
  // escape characters are treated as literals and are printed
  println(raw"This is a \n newline")
  // when saved as a value,
  val escaped = "This is a \n newline"
  // the new lines isn't treated as literal and works normally but rest of string is raw
  println(raw"$escaped \n")
  // contrast with s-interpolation
  println(s"$escaped \n")
}
