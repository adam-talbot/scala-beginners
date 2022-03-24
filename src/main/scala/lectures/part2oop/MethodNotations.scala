package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, val favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // Scala has very permissive naming scheme, can use operators as names of methods
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    // prefix notation method
    def unary_! : String = s"$name what the heck?!"
    // unary methods require a space between name and colon
    // postfix notation method
    def isAlive: Boolean = true
    // apply method
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    // exercise 1
    def +(descriptor: String): Person = new Person(s"$name (the $descriptor)", favoriteMovie)
    // exercise 2
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    // exercise 3
    def learns(topic: String): String = s"$name learns $topic"
    def learnsScala: String = learns("Scala")
    // learnsScala = this learns("Scala")
    // learnsScala = this learns "Scala" // post fix notation
    // exercise 4
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  // alternate syntax to call method - infix notation or operator notation (ONLY WORKS FOR METHODS WITH ONE PARAMETER) aka syntactic sugar
  println(mary likes "Inception")

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  // above method is acting like a operator between two class instances
  // show new method using permissive naming scheme examples
  println(mary + tom)
  println(mary.+(tom))

  // this same syntax works for all native methods in native Scala classes
  println(1 + 2)
  println(1.+(2))
  // ALL OPERATORS ARE METHODS

  // Prefix notation (another form of syntactic sugar)
  val x = -1 // see another way to do this below
  val y = 1.unary_-
  // unary_prefix only works with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  // method cannot have any params
  println(mary.isAlive)
  // syntactic sugar version
  // println(mary isAlive) // not working on this version of Scala, needs imports

  // apply
  println(mary.apply())
  // equivalent for apply method, when class object is called as a function, the compiler looks for an apply method in the class and runs it
  println(mary())

  // test exercise 1
  val maryRockstar = mary + "rockstar"
  println(maryRockstar.name)
  // call in conjunction with apply
  println(maryRockstar())
  // I can call the new instance using the apply
  println((mary + "rockstar")()) // infix notation
  // println((mary.+("rockstar"))()) // standard syntax
  println((mary + "rockstar").apply())
  // println((mary.+("rockstar")).apply())
  // this runs the same way (principle of substitution)

  // test exercise 2
  val olderMary = +mary
  // could also be written: mary.unary_+
  println(s"Hi, my name is ${olderMary.name}, my favorite movie is ${olderMary.favoriteMovie} and I am ${olderMary.age} years old")
  // simpler way to test
  println((+mary).age)

  // test exercise 3
  // test learns method
  println(mary.learns("Python"))
  println(mary.learnsScala)
  // use this function in postfix notation
  // println(mary learnsScala) // postfix doesn't work with my env

  // test exercise 4
  println(mary.apply(2))
  println(mary(2))

  /*
  EXERCISES
  1. Overload the + operator mary + "the rockstar" => new person "Mary (the rockstar)"
  2. Add an age to the Person class with default value of 0
  - Add a unary + operator => new person with the age + 1 (+mary => mary with the age incremented
  3. Add a learns method in the Person class => "Mary learns Scala"
  - Add a learnsScala method, calls learns method with "Scala" (use it in postfix notation)
  4. Overload the apply method to receive a number and return a string
  - mary.apply(2) => "Mary (name) watched Inception (fav movie) 2 times"
  */

}
