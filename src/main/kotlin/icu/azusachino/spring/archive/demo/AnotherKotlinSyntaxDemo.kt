package icu.azusachino.spring.archive.demo

fun main() {
    operations()
    eventLoop()
    testWhen()
    equal()
}

fun operations() {
    var a = 1
    val s1 = "a is $a"

    a = 2
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

    for (i in 0 until 3) {
        print(i)
    }
    println()

    for (i in 2..8 step 2) {
        print(i)
    }
    println()

    for (i in 3 downTo 0) {
        print(i)
    }

    for (c in 'a'..'d') {        // 1
        print(c)
    }
    print(" ")

    for (c in 'z' downTo 's' step 2) { // 2
        print(c)
    }
}

fun eventLoop() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b

fun describe(obj: Any): String =
    when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

fun testWhen() {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}

fun ranges() {
    for (x in 1..5) {
        print(x)
    }

    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    val items = setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }

    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // Using `x * y` yields error because they may hold nulls.
    if (x != null && y != null) {
        // x and y are automatically cast to non-nullable after null check
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

fun whenAssign(obj: Any): Any {
    val result = when (obj) {                   // 1
        1 -> "one"                              // 2
        "Hello" -> 1                            // 3
        is Long -> false                        // 4
        else -> 42                              // 5
    }
    return result
}

// Kotlin uses == for structural comparison and === for referential comparison.
fun equal() {
    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)
    println(authors === writers)
}