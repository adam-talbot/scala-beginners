package lectures.part3fp

import scala.annotation.tailrec

/**
 * Created by Daniel.
 */
object TuplesAndMaps extends App {

//  // tuples = finite ordered "lists"
//  val aTuple = (2, "hello, Scala")  // Tuple2[Int, String] = (Int, String)
//  // can group at most 22 elements of different types
//
//  // print the first element of the tuple
//  println(aTuple._1)  // 2
//  // make a copy and replace the second element
//  println(aTuple.copy(_2 = "goodbye Java"))
//  // swap the 2 elements
//  println(aTuple.swap)  // ("hello, Scala", 2)
//
  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim", 555), "Daniel" -> 789, ("JIM", 9000)).withDefaultValue(-1)
  // default value makes it so that if someone calls a key that does not exist they get this value instead of an error
  // a -> b is sugar for (a, b)
  println(phonebook)

  // map ops
  // takes a key and returns a boolean indicated if that key is present in the map
  println(phonebook.contains("Jim"))
  // will return the value associated with that key
  println(phonebook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  // add method to append a new key value pair to a new map (immutable)
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // map, flatMap, filter

  // mapping just the keys to make them lowercase
  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))
  // do same thing for value
  println(newPhonebook.map(pair => pair._1 -> (pair._2 + 1)))

  // filterKeys - filter keys with some condition
  println(phonebook.view.filterKeys(x => x.startsWith("J")).toMap)
  // mapValues - change all values
  println(phonebook.view.mapValues(number => "0245-" + number).toMap)

//  // conversions to other collections
//  println(phonebook.toList)
//  // produces list of tuples
//  // convert from list of tuple(s) to map
//  println(List(("Daniel", 555)).toMap)
//
//  // create a new list of names
//  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
//  // group them by the first char in each name
//  println(names.groupBy(name => name.charAt(0)))
//  // group by a condition to yield two keys for false and true and the corresponding values for each in a list
//  println(names.groupBy(name => name.charAt(0) == 'J'))

  /*
    1.  What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 900

        One of the entries would be lost
        !!! careful with mapping keys.

    2.  Overly simplified social network based on maps
        Person = String
        - add a person to the network
        - remove
        - friend (mutual)
        - unfriend

        - number of friends of a person
        - person with most friends
        - how many people have NO friends
        - if there is a social connection between two people (direct or not)
   */
//  // use set instead of list to make sure one friend isn't added twice
//  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
//    network + (person -> Set())
//
//  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
//    val friendsA = network(a)
//    val friendsB = network(b)
//
//    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
//  }
//
//  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
//    val friendsA = network(a)
//    val friendsB = network(b)
//
//    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
//  }
//
//  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
//    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
//      if (friends.isEmpty) networkAcc
//      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
//
//    val unfriended = removeAux(network(person), network)
//    unfriended - person
//  }
//
//  // create an empty network
//  val empty: Map[String, Set[String]] = Map()
//  // add two people to the network without any associated set of friends
//  val network = add(add(empty, "Bob"), "Mary")
////  // can also do this in two steps
////  val network = add(empty, "Bob")
////  val network2 = add(network, "Mary")
//  // take a look
//  println(network)
//  // println(network2)
//
//  // Add friendships between Bob and Mary
//  println(friend(network, "Bob", "Mary"))
//  // remove both friendships
//  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
//  // remove Bob from the network
//  println(remove(friend(network, "Bob", "Mary"), "Bob"))
//
//  // Jim,Bob,Mary
//  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
//  val jimBob = friend(people, "Bob", "Jim")
//  val testNet = friend(jimBob, "Bob", "Mary")
//  // Bob and Jim are friends and Bob and Mary are friends, but Jim and Mary are not
//
//  println(testNet)
//  // this should return the set of connections for Bob (calling they key to get the value from the map)
//  // println(testNet("Bob"))
//
//  def nFriends(network: Map[String, Set[String]], person: String): Int =
//    // if network doesn't contain the person, they have no friends in the network
//    if (!network.contains(person)) 0
//    // else get the size of the set associated with that person's friends
//    else network(person).size
//
//  // test method for person with most friends, Bob
//  println(nFriends(testNet, "Bob"))
//  // test method for someone with 1 friend, Jim
//  println(nFriends(testNet, "Jim"))
//  // test method for someone not in network
//  println(nFriends(testNet, "Adam"))
//
//
//  def mostFriends(network: Map[String, Set[String]]): String =
//    // maxBy method will return pair with max value
//    network.maxBy(pair => pair._2.size)._1
//
//  println(mostFriends(testNet))
//
//  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
//  // can do using keys
////    network.filterKeys(k => network(k).isEmpty).size
//  // can do using parings
////  network.filter(pair => pair._2.isEmpty).size
//  // can also use count to make it shorter
////  network.count(pair => pair._2.isEmpty)
//  // can use lambda shortand to make even shorter
//  network.count(_._2.isEmpty)
//
//  println(nPeopleWithNoFriends(testNet))
//
//  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
//    @tailrec
//    // breadth first search in our graph of connections
//    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
//      // haven't found the target and there are no more people to search
//      if (discoveredPeople.isEmpty) false
//      // haven't discovered yet but stil need to search through discoveredPeople
//      else {
//        val person = discoveredPeople.head
//        if (person == target) true
//        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
//        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
//      }
//    }
//
//    bfs(b, Set(), network(a) + a)
//  }
//
//  println(socialConnection(testNet, "Mary", "Jim"))
//  println(socialConnection(network, "Mary", "Bob"))

}
