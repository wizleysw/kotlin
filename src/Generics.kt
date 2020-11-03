/*
Generics
https://kotlinlang.org/docs/reference/generics.html
*/

class Box<T>(t: T){
    var value = t
}

fun main(){
    val box: Box<Int> = Box<Int>(1)
    val box2 = Box(1)
}
