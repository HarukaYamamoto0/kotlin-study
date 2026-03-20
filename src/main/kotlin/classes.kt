package com.harukadev

fun main() {
    val contact = Contact(
        name = "John",
        id = 1,
        email = "johnDoe@gmail.com"
    )

    println("Their email address is: ${contact.email}")
    contact.printId()

    val user = User("john", contact.email)
    println(user)

    val user2 = User("joana", "joanaDoe@gmail.com")
    println(user2)
    println(user === user2)

    val haruka = user2.copy()
    println(haruka)
    println(haruka == user2)

}

class Contact(val id: Int, val name: String, val email: String = "example@gmail.com") {
    val category = "work"

    fun printId() {
        println(this.id)
    }
}

data class User(val name: String, val email: String)