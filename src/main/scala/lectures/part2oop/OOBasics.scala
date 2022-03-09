package lectures.part2oop

object OOBasics extends App {

//  val person = new Person("John", 26)
//  println(person.x)
//  person.greet("Daniel")
//  person.greet()
//
//  // using secondary constructor where age is not required
//  val person2 = new Person("Adam")
//  println(person2.name + " , " + person2.age)
//
//  // using secondary constructor where neither name nor age is required
//  val person3 = new Person()
//  println(person3.name + " , " + person3.age)

//val author = new Writer("Charles", "Dickens", 1812)
//val imposter = new Writer("Charles", "Dickens", 1812)
//val novel = new Novel("Great Expectations", 1861, author)
//
//// check functionality of authorAge method
//println(novel.authorAge)
//
//// check isWrittenBy
//println(novel.isWrittenBy(author))
//// returns true
//println(novel.isWrittenBy(imposter))
//// returns false
//// brings up topic of equality in OOP, returns false since instance name is different even though class signature is identical
//
//// check values for original instance of novel
//println(s"name: ${novel.name}, release year: ${novel.releaseYear}, author: ${novel.author.fullName}")
//
//// create new novel instance with updated release year
//val newNovel = novel.copy(1865)
//
//// check values of new novel
//println(s"name: ${newNovel.name}, release year: ${newNovel.releaseYear}, author: ${newNovel.author.fullName}")

//// test functionality of Counter class
//// create new instance
//val counter = new Counter
//
//// try incrementing and decrementing
//val newCounter = counter.inc.inc.inc.dec(2)
//println(newCounter.count)

// test CountLog class
val counterLog = new CounterLog

// try incrementing and decrementing
// val newCounterLog = counterLog.inc(4).inc.dec(2).print
counterLog.inc(4).inc.dec(2).print

}

//class Person(name: String, age: Int) // constructor - these two values  must be passed each time an instance of the class is created
// class parameters are not fields, cannot be accessed via class.paramname notation as in other languages

// make the class params into fields that can be accessed via dot notation (should not be done for all params)
class Person(val name: String, val age: Int) {
  // body
  // can have:
  // val and var definitions - used as fields
  val x = 2

  // expressions - will be evaluated at each instance
  println(1 + 3)

  // functions/methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // this.name refers to the class attributes/params/fields/properties not the local variable in the function/method
  // only needed in case of ambiguity, if not ambiguity will default to class property
  def greet(): Unit = println(s"Hi, I am $name")
  // implied to be field from class params
  // overloading - can have multiple methods with same name, but compiler will identify them based on signatures (params, param types, return types, etc)
  // cannot have overloaded methods with same name and same args but different return value
  // def greet(): Int = 42

  // definitions (other modules, classes, etc)

  // multiple constructors
  // creating another constructor that will apply default value to age
  def this(name: String) = this(name, 0)
  // create another constructor that will apply default values to name and age
  def this() = this("John Doe", 15)
  // implementation of secondary constructor has to be another constructor AND NOTHING ELSE
  // BECAUSE OF THIS LIMITATION, THE ONLY PRACTICAL USE FOR SECONDARY CONSTRUCTORS ARE TO SET DEFAULT PARAMS, WHICH YOU CAN DO IN THE CLASS SIGNATURE
  // e.g. class Person(val name: String = "John Doe", val age: Int = 15) {
  // THEREFORE, SECONDARY CONSTRUCTORS ARE NOT USED MUCH IN PRACTICE IN SCALA

}

/*

Writer class
- fields: first name, surname, year
- method: fullname

Novel Class
- name, year of release, author
- Methods: authorAge, isWrittenBy (author),  copy(new year of release) = new instance of Novel

Counter Class
- fields: int
- methods: current count, increment(new counter returned), decrement(new counter)
- overload inc/dec to receive amount of increments
*/

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullName: String = firstName + " " + surname
}

// can use name of another class as param for new class in signature
class Novel( val name: String, val releaseYear: Int, val author: Writer) {
  // method that returns age of author at time of release
  def authorAge = releaseYear - author.year

  // method that checks if author info is consistent
  def isWrittenBy(author: Writer) = author == this.author

  // method that adds a new release year to a novel
  def copy(newReleaseYear: Int): Novel = new Novel(name, newReleaseYear, author)
}

class Counter(val count: Int = 0) {
  // method to return the current count (old signature had param as n)
  // def count = n
  // not needed, can just change from param to field in signature
  def inc = new Counter(count + 1) // immutability - don't modify instance inside, create a new instance with new properties
  def dec = new Counter(count - 1)

  // overload but allow incrementer to change
  def inc(n: Int) = new Counter(count + n)
  def dec(n: Int) = new Counter(count - n)
}

// create a class that counts but also has ability to log something at each change
class CounterLog(val count: Int = 0) {

  def inc = {
    println("incrementing")
    new CounterLog(count + 1)
  } // immutability - don't modify instance inside, create a new instance with new properties
  def dec = {
    println("decrementing")
    new CounterLog(count - 1)
  }

  // overload but allow incrementer to change
  def inc(n: Int): CounterLog = {
    // if no counting needed, return as is since incrementing is not needed
    // base case
    if (n <= 0) this
    // else call the increment function until you get to base case
    else inc.inc(n-1)
  }
  def dec(n: Int): CounterLog = {
    if (n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(count)
}
