package icu.azusachino.spring.archive.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HtmlController {

    @GetMapping("/")
    fun blog(model: String): String {
        println("ok")
        return "blog"
    }
}
