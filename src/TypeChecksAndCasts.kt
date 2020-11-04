/*
Type Checks and Casts
https://kotlinlang.org/docs/reference/typecasts.html
*/

fun isOperator(){
    val obj = "ABC"
    if(obj is String){
        print(obj.length)
    }

    if(obj !is String){
        print("Not a String")
    }
}

fun demo(x: Any){
    if(x is String){
        print(x.length)
    }
}

fun unsafeCastOperator(y: Any){
    // Cast Operator throws an Exception if the cast is not possible
    val x: String = y as String

    // null can't be cast to String as this type is not nullable
    val z: String?= y as String?

    // to avoid an exception being thrown, as? returns null on failure
    val q: String?= y as? String
}