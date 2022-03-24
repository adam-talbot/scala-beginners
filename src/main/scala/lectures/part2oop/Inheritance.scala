package lectures.part2oop

object Inheritance extends App {

  // define a class (Animal is the super class in this example)
  class Animal {
    // public method
    def eat = println("nomnom")
    // private method
    private def burp = println("BURP")
    // protected method (can only be accessed in this class and subclasses)
    protected def scarf = println("NOMNOM")

    // val overriding
    val creatureType = "wild"

  }
  // extend the class (inherit all non private parts of class into a new class)
  // Cat is a sub class of Animal
  // Single class inheritance, can only extend one class at a time
  class Cat extends Animal {
    def crunch = {
      // call the protected class
      scarf
      println("CRUNCHING")
    }
  }

  val cat = new Cat
  cat.eat

  // this cannot be inherited since it is private
  // cat.burp

  // call the protected method
  cat.crunch
  // the protected method can only be called within a method of the subclass
  // cannot be called directly
  // cat.scarf

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  // this is invalid, must provide params for superclass
  // class Adult(name: String, age: Int, idCard: String) extends Person
  // this is valid (provided both params)
  class Adult1(name: String, age: Int, idCard: String) extends Person(name, age)
  // this is valid (provided param for auxiliary constructor that is defined as part of superclass)
  class Adult2(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog extends Animal {
    // you can override a superclass method inside of a subclass
    override def eat = {
      // can use super to access method from super class
      super.eat
      println("burp, burp")
    }

    // override a val
    override val creatureType = "domestic"
    // can also move this overriding into the signature of the subclass definition (e.g. class Dog(override val creatureType: String) extends Animal ..
    // when creating new subclass: val dog = new Dog("K9")
    // another way
    // class Dog(dogType: String) extends Animal {
    //  override val creatureType = dogType }
  }

  val dog = new Dog
  // this method is now public since it has been overridden
  dog.eat

  // test overriding val
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog
  println(unknownAnimal.creatureType)
  // even though the type is the Animal class, we used the subclass for implementation and the overridden method was used

  // Distinction between overRIDING and overLOADING
  // riding is same name but different implementation within a subclass
  // loading is same name but different signature within same class

  // preventing overrides
  // 1. use final on method definition in superclass
  // 2. put final modifier on whole superclass
  // 3. seal the class - class can be extended in this file only, but not in other files "sealed" modifiers
  // - used when you want to limit amounts of subclasses to those defined in this current file

}
