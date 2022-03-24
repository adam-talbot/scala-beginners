package lectures.part2oop

// import playground.{PrinceCharming, Cinderella => Princess} // didn't add these to playground
// ._ imports all methods from class
import java.util.Date
import java.sql.{Date => SqlDate} // this is how you alias upon import (if importing multiple with same name)

object PackagingAndImports extends App {

  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package if class is in different package
  //val princess = new Princess  // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure.

  // package object, vals methods defined in package object accessible in entire package by simple name
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  //val prince = new PrinceCharming

  // 1. use FQ names
  val date = new Date
  val sqlDate = new SqlDate(2018, 5, 4)
  // 2. use aliasing

  // default imports
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
