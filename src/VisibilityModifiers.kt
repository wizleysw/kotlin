/*
Visibility Modifiers
https://kotlinlang.org/docs/reference/visibility-modifiers.html
https://kotlinlang.org/docs/reference/sealed-classes.html
*/

// public : if do not specify visibility modifier by default
// private : visible inside file
// internal : visible everywhere in the same module
// protected : private + subclass

// Internal visibility modifier means that the member is visible within the same module
// a module is a set of kotlin files compiled together
fun baz() {}

private fun foo(){}

internal const val vaz = 6

open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass: Outer(){
    // Outer's a is not visible
    // b,c, and d are visible
    // Nested and e are visible
    override val b = 5
}

class Unrelated(o: Outer){
    // o.a, o.b is not visible
    // o.c and o.d are visible ( same module )
    // o.Nested and o.Nested.e are not visible
}

// Sealed classes are used for representing restricted class hierarchies
// value can have one of the types from a limited set, but cannot have any other type
// only same file can inherit sealed class
// abstract by itself
sealed class Expr
data class Const(val number: Double) : Expr()
data class Sum(val e1: Expr, val e2: Expr) : Expr()
object NotANumber: Expr()
