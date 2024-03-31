package icu.azusachino.spring.archive

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlueArchiveApplication

fun main(args: Array<String>) {
    val ph = ProcessHandle.current()
    println("process id: ${ph.pid()}")
    println("is alive?: ${ph.isAlive}")
    runApplication<BlueArchiveApplication>(*args) {
        setBannerMode(Banner.Mode.OFF)
//        setRegisterShutdownHook(true)
    }
    print(args.contentToString())
}
