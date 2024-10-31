package test2

interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {
    override fun printMessage() { println(x) }
    override fun printMessageLine() { println(x) }
}


class BaseImpl2(val x: Int) : Base {
    override fun printMessage() { println("2 $x") }
    override fun printMessageLine() { println(x) }
}

class Derived(var b: Base) : Base by b {
    
}

fun main() {
    val base1 = BaseImpl(10)
    val base2 = BaseImpl(12)
    val derived = Derived(base1)
    derived.printMessage()
    derived.b = base2
    derived.printMessageLine()
}