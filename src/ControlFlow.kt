/*
Control Flow
https://kotlinlang.org/docs/reference/control-flow.html
*/

fun ifExpression(){
    val a = 3
    val b = 6
    var max = if(a>b) a else b

    if(a>b){
        max = a
    } else {
        max = b
    }
}

fun whenExpresssion(){
    val x = 6

    when(x){
        1 -> println("x == 1")
        2 -> println("x == 2")
        3,4 -> println("x == 3 or 4")
        !in 0..4 -> println("x is out of range")
        else -> println("x is not 1 or 2")
    }

    fun hasPrefix(x: Any) = when(x){
        is String -> x.startsWith("prefix")
        else -> false
    }
    println(hasPrefix(x))
}

fun forLoops(){
    val collection = arrayOf(1,2,3,4)
    for(item in collection) println(item)

    for(item: Int in collection){
        println(item)
    }

    for(i in 1..3){
        println(i)
    }

    for(i in 6 downTo 0 step 2){
        println(i)
    }

    for(i in collection.indices){
        println(collection[i])
    }

    for((index, value) in collection.withIndex()){
        println("the element at $index is $value")
    }
}

fun whileLoop(){
    var x = 5

    while(x>0){
        x--
    }

    do {
        x++
    } while(x<10)
}

fun main(){
    ifExpression()
    whenExpresssion()
    forLoops()
    whileLoop()
}