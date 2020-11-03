import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
Delegated Properties
https://kotlinlang.org/docs/reference/delegated-properties.html
*/

// operator is required whenever you wish to be able to use a function as if it were an operator
// In this case, it's rather keyword or functions that have another convention they can be called with
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String{
        return "$thisRef, thank you for delegating '${property.name}' to me !"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p: String by Delegate()
}

val lazyValue: String by lazy {
    println("Computed")
    "hello"
}

class User {
    var name: String by Delegates.observable("<no name>"){
        prop, old, new ->
        println("$old -> $new :: $prop")
    }
}

//var topLevelInt: Int = 0
//class ClassWithDelegate(val anotherClassInt: Int)
//class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate){
//    var delegatedToMember: Int by ::memberInt
//    var delegatedToTopLevel: Int by ::topLevelInt
//
//    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
//}
//var MyClass.extDelegated: Int by ::topLevelInt


fun main(){
    // Example@1a93a7ca, thank you for delegating 'p' to me !
    val e = Example()
    println(e.p)
    // Example@1a93a7ca, thank you for delegating 'p' to me !
    e.p = "NEW"

    // Computed
    // hello
    println(lazyValue)
    // hello
    println(lazyValue)

    // <no name> -> first :: var User.name: kotlin.String
    // first -> second :: var User.name: kotlin.String
    val user = User()
    user.name = "first"
    user.name = "second"
}