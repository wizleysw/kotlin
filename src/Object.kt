

class ObjectTest{
    object JustObject {
        val name = "JustObject"

        fun printName(){
            println("$name")
        }
    }

    companion object CompanionObject{
        val name = "CompanionObject"

        fun printName(){
            println("$name")
        }
    }
}

fun main(){
    ObjectTest.JustObject.printName()

    ObjectTest.CompanionObject.printName()
    ObjectTest.printName() // -> Companion Object's printName is called
}