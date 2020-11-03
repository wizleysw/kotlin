/*
Properties and Fields
https://kotlinlang.org/docs/reference/properties.html
*/

// Constants is used when allocate info at compile time
// Top-level or member of an object declaration or a companion object
// Initialized with a value type String or a primitive type
// No custom getter
const val NAME: String = "Wizley"

fun lateAllocate(){
    lateinit var subject: String

    fun set(sub: String){
        subject = sub
    }
}

fun main(){

}