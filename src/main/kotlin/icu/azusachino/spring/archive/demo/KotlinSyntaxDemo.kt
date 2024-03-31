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