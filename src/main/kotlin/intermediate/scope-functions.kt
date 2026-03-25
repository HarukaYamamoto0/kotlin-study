package com.harukadev.intermediate

fun main() {
    val address: String? = getNextAddress()
    val confirm = address?.let {
        sendNotification(it)
    }
    println(confirm)

    val client = Client().apply {
        token = "sds"
    }

    val result = client.run {
        connect()
        authenticate()
        getData()
    }

    println(result)

    val medals = listOf("Gold", "Silver", "Bronze")
    medals
        .map { it.uppercase() }
        .filter { it.length > 4 }
        .also { println(it) } // without side effects 🎉
        .reversed()
        .also { println(it) }

    val mainMonitorPrimaryBufferBackedCanvas = Canvas1()

    with(mainMonitorPrimaryBufferBackedCanvas) {
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }
}

fun sendNotification(recipientAddress: String): String {
    println("Yo, $recipientAddress")
    return "Notification sent!"
}

fun getNextAddress(): String? {
    return listOf("sebastian@jetbrains.com", "harukayamamotodev@gmail.com", null).random()
}

class Client() {
    var token: String? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData(): String {
        println("getting data!")
        return "Mock data"
    }
}

class Canvas1 {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}