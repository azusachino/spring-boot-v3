package icu.azusachino.spring.archive.demo

import java.util.*

fun main() {
    dataClassDemo()
}

// Data classes make it easy to create classes that are used to store values.
// Such classes are automatically provided with methods for copying,
// getting a string representation, and using instances in collections.
data class User(val name: String, val id: Int) {           // 1
    override fun equals(other: Any?) =
        other is User && other.id == this.id               // 2

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + id
        return result
    }
}

fun dataClassDemo() {
    val user = User("Alex", 1)
    println(user)                                          // 3

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser: ${user == secondUser}")   // 4
    println("user == thirdUser: ${user == thirdUser}")

    // hashCode() function
    println(user.hashCode())                               // 5
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // copy() function
    println(user.copy())                                   // 6
    println(user === user.copy())                          // 7
    println(user.copy("Max"))                              // 8
    println(user.copy(id = 3))                             // 9

    println("name = ${user.component1()}")                 // 10
    println("id = ${user.component2()}")
}

enum class Color(val rgb: Int) {                      // 1
    RED(0xFF0000),                                    // 2
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)  // 3
}

fun enumClassDemo() {
    val red = Color.RED
    println(red)                                      // 4
    println(red.containsRed())                        // 5
    println(Color.BLUE.containsRed())                 // 6
    println(Color.YELLOW.containsRed())               // 7
}

// Sealed classes let you restrict the use of inheritance.
// Once you declare a class sealed, it can only be subclassed from inside the same package where the sealed class is declared.
// It cannot be subclassed outside the package where the sealed class is declared.
sealed class Mammal(val name: String)                                                   // 1

class Cat(private val catName: String) : Mammal(catName)                                        // 2
class Human(private val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    return when (mammal) {                                                                     // 3
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
        is Cat -> "Hello ${mammal.name}"                                         // 5
    }                                                                                   // 6
}

class LuckDispatcher {                    //1
    fun getNumber() {                     //2
        val objRandom = Random()
        println(objRandom.nextInt(90))
    }
}

// object It is used to obtain a data type with a single implementation.
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")

    DoAuth.takeParams("a", "b")
}

object DoAuth {                                                 //1
    fun takeParams(username: String, password: String) {        //2
        println("input Auth parameters = $username:$password")
    }
}

class BigBen {
    companion object Bong {
        fun getBongs(nTimes: Int) {
            for (i in 1..nTimes) {
                print("BONG ")
            }
        }
    }
}