package icu.azusachino.spring.archive.demo

import com.sun.net.httpserver.HttpServer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.nio.file.Files
import java.nio.file.Path
import java.text.NumberFormat
import java.util.stream.Collectors

class KotlinSyntaxDemo {
}

// kotlin classes
class Shape

class Rectangle(private val height: Double, private val length: Double) {
    val perimeter = (height + length) * 2
}

@RestController
@RequestMapping
class Controller {

    @GetMapping
    fun todo(): String {
        val rectangle = Rectangle(5.0, 2.0)
        println("the perimeter is ${rectangle.perimeter}")
        return "what a nightmare"
    }
}


@Configuration
class AnotherWebConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate();
    }
}

fun tests() {
    // java 9
    val numbers = listOf(1, 2, 3, 4, 5);
    val another = numbers.stream()
        .takeWhile { n -> n < 2 }
        .collect(Collectors.toList())
    println("data $another")

    val httpClient = HttpClient.newHttpClient();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://example.com"))
        .GET()
        .build();
    val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())
    println("body ${response.body()}")

    // java 11
    val data = Files.readString(Path.of("README.md"))
    println("data $data")
    // java 12
    val nf = NumberFormat.getCompactNumberInstance()
    println("short format: ${nf.format(1000)}")

    // java 15
    val html = """
              <html>
                  <body>
                      <p>Hello, world</p>
                  </body>
              </html>
        """.trimIndent()
    print(html)

    // java 18
    val server = HttpServer.create();
    server.start()

    // java 21
    // Thread.ofVirtual().unstarted { -> println("vola") };
}

// kotlin functions

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumInt(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

class Person(val name: String) {
    private val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }
}

fun infixFunc() {
    infix fun Int.times(str: String) = str.repeat(this)

    print(2 times "Bye")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

// Certain functions can be "upgraded" to operators, allowing their calls with the corresponding operator symbol.
fun operatorFun() {
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}

fun vars() {

    fun printAll(vararg messages: String) {
        for (m in messages) println(m)
    }
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    fun printAllWithPrefix(vararg messages: String, prefix: String) {
        for (m in messages) println(prefix + m)
    }
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )

    fun log(vararg entries: String) {
        printAll(*entries)
    }
    log("Hello", "Hallo", "Salut", "Hola", "你好")
}

fun describeString(maybeString: String?): String {
    return if (!maybeString.isNullOrEmpty()) {
        "String of length ${maybeString.length}"
    } else {
        "empty or null"
    }
}

class MutableStack<E>(vararg items: E) {              // 1

    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)        // 2

    fun peek(): E = elements.last()                     // 3

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString() = "MutableStack(${elements.joinToString()})"
}

fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

open class Dog {                // 1
    open fun sayHello() {       // 2
        println("wow wow!")
    }
}

class Yorkshire : Dog() {       // 3
    override fun sayHello() {   // 4
        println("wif wif!")
    }
}

open class Tiger(private val origin: String) {
    fun sayHello() {
        println("A tiger from $origin says: grrhhh!")
    }
}

class SiberianTiger : Tiger("Siberia")

open class Lion(val name: String, val origin: String) {
    fun sayHello() {
        println("$name, the lion from $origin says: graoh!")
    }
}

class Asiatic(name: String) : Lion(name = name, origin = "India")