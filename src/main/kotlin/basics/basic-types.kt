package com.harukadev.basics

fun main() {
    var customers = 5

    customers = 9

    customers = customers - 1
    customers-- // syntax sugar

    customers = customers + 1
    customers++ // syntax sugar

    customers += 1
    customers /= 2
    customers *= 2
    customers %= 2
    customers += 64

    println(customers.toChar())

    // Integers
    val byte: Byte = 127 // 8 bits: -127..+128
    val short: Short = 32767 // 16 bits: -32768..+32767
    val int: Int = 2_147_483_647 // 32 bits: -2_147_483_647..+2_147_483_646
    val long: Long = -9_223_372_036_854_775_807 // 64 bits: -9_223_372_036_854_775_807..+9_223_372_036_854_775_807

    // Unsigned types
    val uByte: UByte = 255u // 8 bits: 0..255
    val uShort: UShort = 65_535u // 16 bits: 0..65_535
    val uInt: UInt = 4_294_967_295u // 32 bits: 0..4_294_967_295
    val uLong: ULong = 18_446_744_073_709_551_615u // 64 bits: 0..18_446_744_073_709_551_615

    // This happens because unsigned tufts do not represent negative numbers, thus allowing them to use all the space

    // Floating-point numbers
    val float: Float = Float.MAX_VALUE // 32 bits: 0..~3_4028235E38
    val double: Double = Double.MAX_VALUE // 64 bits: 0..~1_7976931348623157E308

    // Booleans
    val isAuthenticated: Boolean = true // 1 byte: 0..1

    // Characters
    val specialChar: Char = '?' // 2 bytes: 0x0000..0xFFFF
    val letter: Char = 'a'
    val tab: Char = '\n' // Even though visually it's two characters, that's the representation of the Tab key

    // Strings
    val fullName = "Haruka Yamamoto Atsuko Akemi"
}