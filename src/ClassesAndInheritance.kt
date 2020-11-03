/*
Classes and Inheritance
https://kotlinlang.org/docs/reference/classes.html
*/

fun primaryConstructors(){
    // Primary Constructor
    // Can not contain any code
    class Person constructor(firstName: String)

    // Primary Constructor can be used this way
    class Person2(firstName: String)
}

fun initializeConstructors(){
    // Initialization is executed in the same order as they appear in the class body
    class InitOrderDemo(name: String){
        val firstProperty = "First Property: $name".also(::println)

        init {
            println("First Initializer block tha prints ${name}")
        }

        val secondProperty = "Second Property: ${name.length}".also(::println)

        init {
            println("Second Initializer block that prints ${name.length}")
        }
    }

    // First Property: Wizley
    // First Initializer block tha prints Wizley
    // Second Property: 6
    // Second Initializer block that prints 6
    InitOrderDemo("Wizley")
}

fun secondaryConstructors(){
    class Person(val name: String) {
        var children: MutableList<Person> = mutableListOf()

        init {
            println("init")
        }

        constructor(name: String, parent: Person) : this(name){
            parent.children.add(this)
            println("constructor")
        }
    }

    // init
    val dad = Person("Wizley")

    // init
    // constructor
    Person("Wizley-second", dad)
}

fun inheritance(){
    // superclass is Any
    // Implicitly inherits from Any
    class Example

    // Default kotlin classes are final and can't not be inherited
    // To make it inheritable, open keyword is needed
    open class Base

    // To declare an explicit supertype, place the type after a colon in the class header
    open class BaseClass(p: Int)
    class DerivedClass(p: Int): BaseClass(p)
}

fun overridingProperty(){
    open class Shape {
        open val vertexCount: Int = 0
    }

    // open -> can be overrided by child
    // val -> var is possible, not vice versa
    class Rectangle: Shape(){
        override var vertexCount = 4
    }
}

fun derivedClassInitializationOrder(){

    // By the time the base constructor execution,
    // the properties declared or overriden in derived class are not initialized
    // Therefore, avoid using open members in constructors
    open class Base(val name: String){
        init { println("Init Base")}

        open val size: Int = name.length.also { println("Init size in Base : $it")}
    }

    class Derived(name: String, val lastName: String): Base(name.capitalize().also {
        println("Argument for Base: $it")}){

        init { println("Init Derived")}

        override val size: Int = (super.size + lastName.length).also { println("Init size of Derived: $it") }
    }

    // Argument for Base: Wizley
    // Init Base
    // Init size in Base : 6
    // Init Derived
    // Init size of Derived: 9
    Derived("Wizley", "^_^")
}

fun callOpenClassMethod(){
    open class Rectangle {
        open fun draw() { println("Drawing a rectangle") }
        val borderCount: String get() = "black"
    }

    class FilledRectangle: Rectangle(){
        override fun draw() {
            super.draw()
            println("Filling the rectangle")
        }

        val fillColor: String get() = super.borderCount

        inner class Filter {
            fun fill() {}
            fun drawAndFill(){
                super@FilledRectangle.draw() // super keyword to call superclass's method from inner class
                fill()
            }
        }
    }

    FilledRectangle().draw()
}

interface Polygon {
    fun draw(){} // open by default
}
fun overrideSameMembers(){
    open class Rectangle{
        open fun draw(){}
    }

    class Square(): Rectangle(), Polygon {
        override fun draw(){
            super<Rectangle>.draw()
            super<Polygon>.draw()
        }
    }
}

fun main(){
//    primaryConstructors()
//    initializeConstructors()
//    secondaryConstructors()
//    inheritance()
//    overridingProperty()
//    derivedClassInitializationOrder()
//    callOpenClassMethod()
    overrideSameMembers()
}