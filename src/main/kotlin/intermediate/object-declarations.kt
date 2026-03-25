package com.harukadev.intermediate

fun main() {
    DoAuth.takeParams(username = "HarukaYamamoto0", password = "N1njaC0ding")

    println(DoAuth) // com.harukadev.intermediate.DoAuth@5c647e05
    println(AppConfig) // AppConfig

    println(AppConfig.appName) // Study

    BigBen.getBongs(12)
}

interface Auth {
    fun takeParams(username: String, password: String)
}

object DoAuth : Auth {
    override fun takeParams(username: String, password: String) {
        println("input Auth parameters = $username:$password")
    }
}

data object AppConfig {
    var appName = "Study"
    var appVersion = "1.1.0"
}

class BigBen {
    companion object Bonger {
        fun getBongs(nTimes: Int) {
            repeat(nTimes - 1) {
                print("BONG ")
            }
            println("BONG")
        }
    }
}