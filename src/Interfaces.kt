/*
Interfaces
https://kotlinlang.org/docs/reference/interfaces.html
*/

interface MyInterface {
    val prop: Int // abstract

    fun bar()
    fun foo(){
        println(prop)
    }
}

interface MySecondInterface: MyInterface {
    override fun bar() {
        println("bar2")
    }
}

class Child(override val prop: Int) : MyInterface{
    override fun bar() {
        println("bar")
    }
}

