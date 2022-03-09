package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static" in Java)
  // Has objects instead - even better
  // can have static values (vals and vars) and methods
  // do not have any parameters
  // singleton instance
  // can only have one instance
  object Person {
    // "static/class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = false
    // factory methods
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  // you can also define a class with the same name and use them together
  class Person(val name: String) {
    // instance-level functionality
  }

  // when object and class with same name are written in same scope they are called COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)
  // these are not equal since they are pointing to different instances


  // you can define new instances of the class
  val person1 = Person
  val person2 = Person
  println(person1 == person2)
  // they are pointing to the same thing, there is only one instance of the object

  val bobbie = Person.apply(mary, john)
  // or val bobbie = person(mary, john) // special apply syntax
  println(bobbie.name)

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
  // you can either write this as an object and put all code inside, or just add the "extends App", either will make it runnable on JVM

}
