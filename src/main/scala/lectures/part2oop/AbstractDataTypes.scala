package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract - don't provide values for vals/vars and methods for superclass since subclasses will
  abstract class Animal {
    val creatureType: String = "wild"
    def eat : Unit
    // can have abstract and non abstract vals/vars and methods
  }
  // abstract classes cannot be instantiated directly

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
    // override modifier not necessary here since no prior implementation, but can be used
  }

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
    // can have abstract and non abstract vals/vars and methods
  }

  // extend a class using a trait to get access the the abstract method from the trait (can add multiple traits to a class using with keyword
  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // 1. Traits do not have constructor params
  // 2. Multiple traits may be inherited by the same class (classes can only be inherited once)
  // 3. traits = behavior, abstract class = "thing"

}
