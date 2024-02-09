package icu.azusachino.spring.archive

import com.sun.net.httpserver.HttpServer
import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
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
import java.util.*
import java.util.stream.Collectors

@SpringBootApplication
class WhateverProjectApplication

fun main(args: Array<String>) {
    val ph = ProcessHandle.current()
    println("process id: ${ph.pid()}")
    println("is alive?: ${ph.isAlive()}")
    runApplication<WhateverProjectApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
//        setRegisterShutdownHook(true)
    }
}

@RestController
@RequestMapping
class Controller {

    @GetMapping
    fun todo(): String {
        return "what a nightmare"
    }


}


@Configuration
class WebConfig {

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate();
    }
}

class JavaApis {

    fun tests() {
        // java 9
        val numbers = Arrays.asList(1, 2, 3, 4, 5);
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

        val h = "hello\nworld"
        println("string indented: ${h.indent(3)}")

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
        Thread.ofVirtual().unstarted { -> println("vola") };
    }
}

interface PrivateMethod {
    private fun pp() {
        println("guess what")
    }

    fun i()
}

sealed class Shape {

}

class Circle : Shape() {

}
