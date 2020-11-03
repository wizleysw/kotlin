/*
Returns and Jumps
https://kotlinlang.org/docs/reference/returns.html
*/

fun simpleReturn(){
    val person = "wizley"
    val s = (person == "Wizley") ?: return

    println(s)
}

fun loopWithLabel(){
    loop@ for(i in 1..100){
        for(j in 1..100){
            if(i==10 && j==20) break@loop
        }
    }
}

fun returnWithExplicitLabel(){
    listOf(1,2,3,4,5).forEach lit@{
        if(it == 3) return@lit
        println(it) // 1,2,4,5, is called
    }
    println("Done with Explicit Label")
}

fun returnWithImplicitLabel(){
    listOf(1,2,3,4,5).forEach {
        if(it == 3) return@forEach
        println(it)
    }
    println("Done with Implicit Label")
}

fun returnWithAnonymousFunction(){
    listOf(1,2,3,4,5).forEach(fun(value: Int){
        if(value == 3) return
        print(value)
    })

    println("Done with anonymous Function")
}

fun returnWithNestedLoop(){
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop
            println(it)
        }
    }
    println("Done with nested loop")

    // This means return 1 at label @a
    // return@a 1
}

fun main(){
    simpleReturn()
    loopWithLabel()
    returnWithExplicitLabel()
    returnWithImplicitLabel()
    returnWithAnonymousFunction()
    returnWithNestedLoop()
}

