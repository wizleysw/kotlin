/*
Delegation
https://kotlinlang.org/docs/reference/delegation.html
*/

// 코틀린에서는 기본적으로 모든 클래스가 final이기에 open을 하지 않으면 상속이 불가능함
// by 키워드는 구현해야될 메소드들을 객체로 위임함을 나타냄
// 인터페이스를 implement하면 내부의 abstract 메소드들을 다 구현해야됨
// 이런 경우에 delegate를 통하여 코드의 구현부분을 다른 객체에게 위임할 수 있음
// 아래의 Derived 클래스는 print라는 method의 구현코드를 BaseImpl에게 위임하는 형태
// 이렇게 하면 모든 메소드를 다시 구현할 필요가 없어
// 결과적으로 boiler plate 코드가 많이 줄어드는 효과가 있음
// 멤버 변수의 경우 위임받은 객체에서 아래의 message와 같이 override를 하여도 위임객체 내부의 message가 사용
interface Base {
    val message : String
    fun print()
    fun abc()
}

class BaseImpl(val x: Int) : Base됨 {
    override fun print() {
        println(message)
    }

    override fun abc() {
        println("abc1")
    }

    override val message = "BaseImpl: $x"
}

// b will be stored internally in objects of derived
// and the compiler will generate all the methods of Base that forward to b
class Derived(b: Base) : Base by b {
    override fun abc(){
        println("abc2")
    }
    fun abcd(){
        println("abcd")
    }

    // This property is not access from b's implementation of print
    override val message = "This is Derived class"
}

// BaseImpl: 10
// abc2
// abcd
fun main(){
    val b = BaseImpl(10)
    Derived(b).print()
    Derived(b).abc()
    Derived(b).abcd()
}