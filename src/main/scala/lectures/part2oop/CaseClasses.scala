package lectures.part2oop

object CaseClasses extends App {

  /*
  eliminates a lot of boilerplate code for useful methods:
  equals, hashCode, toString
 */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields by default (no val needed)
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // returns true for case class, would return false for regular class (different instances)

  // 4. CCs have handy copy method (can copy and change params simultaneously)
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person // companion object
  val mary = Person("Mary", 23) // enter params, defaults to apply method (constructor)
  // don't have to use key word "new"

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  // will discuss this more later in the course

  // there is such a thing as a case object (same as case class, just don't have companion object (they are the companion object)
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
    Expand MyList - use case classes and case objects
   */

}
