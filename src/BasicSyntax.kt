import kotlin.math.exp

/*
Basic Syntax
https://kotlinlang.org/docs/reference/basic-types.html
*/

fun numbers(){
    val one = 1
    val threeBillion = 300000000
    val oneLong = 1L
    val oneByte: Byte = 1
    val pi = 3.14
    val eFloat = 2.7182717274f

    val oneMillion = 1_000_000
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11011010101
}

// numbers are physically stored unless nullable reference involved
// if nullable boxed value is stored
fun representation(){
    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int?= b

    // This is related to caching of JVM.
    // Integers ranges from -128 and 127 is cached
    // a is within range so same reference is used
    // however b is not within range, so cached value is not expected to be used
    println(boxedA === anotherBoxedA) // true
    println(boxedB === anotherBoxedB) // false

    // It preserves equality
    println(boxedB == anotherBoxedB) // true
}

fun explicitConversion(){
    val a: Int? = 1 // boxed int
    val b: Long?= a?.toLong()
    println(b?.equals(a)) // false => type check

    // error as smaller type is not converted to bigger types
    // val by: Byte = 1
    // val i: Int = by
    val by: Byte = 1
    val i: Int = by.toInt()

    // print : prints String which is inside the double quotes
    // println : output screen cursor goes to the beginning of the next line
    println(i)
}

fun bitwiseOperation(){
    val x = (1 shl 2) and 0x000FF000
    println(x)

    val y = (1 shl 2) and 0x4
    println(y)
}

fun unsignedLiteral(){
    val b: UByte = 1u
    val s: UShort = 1u
    val l: ULong = 1u

    val a = 0xFFFF_FFFF_FFFFu // ULong
}

fun stringTemplates(){
    val s = "abc"
    println("$s.length is ${s.length}")

    val price = """
        ${'$'}9.99
    """.trimIndent()

    println(price)
}

fun main(){
    numbers()
    representation()
    explicitConversion()
    bitwiseOperation()
    unsignedLiteral()
    stringTemplates()
}