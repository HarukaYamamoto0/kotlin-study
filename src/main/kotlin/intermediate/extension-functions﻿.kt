package com.harukadev.intermediate

fun main() {
    println("Hello".bold())

    val client = HttpClient()
    val getResponseWithMember = client.request("GET", "https://example.com", emptyMap())
    val getResponseWithExtension = client.post("https://example.com")
}

fun String.bold() = "<b>$this</b>"

class HttpClient {
    fun request(method: String, url: String, headers: Map<String, String>) {
        println("Requesting $method to $url with headers: $headers")
    }
}

fun HttpClient.get(url: String) = request("GET", url, emptyMap())
fun HttpClient.post(url: String) = request("POST", url, emptyMap())