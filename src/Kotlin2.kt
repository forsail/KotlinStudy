import extension.testExtensionOutSide
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2017/8/18.
 */
fun main(args: Array<String>) {
    var people = People("shae")
    People.id = 3
    println(People.id)
    println(test2)

    var student = Student("jack", 40, "nanjing")
    student.testExtensionOutSide("dadsa")

    var intA: Int? = null
    var intB: Int? = null
    println(intA?.unaryPlus())
    println(intA == intB)

    var aList: List<String> = listOf("a", "b", "c")
    var bList = aList.map { x -> x + "s" }
    var cList = aList.map { it + "s" }
    for (item in bList) {
        println(item)
    }

    println(+people)

    try {
        test()
    } catch (e: Exception) {
        println("excption")
    }

}

fun test() {
    thread {
        try {
            throw ArithmeticException("error")
        } catch (e: Exception) {

        }
    }
}

fun <T> singletonList(item: T): List<T> = listOf(item)

fun sum(a: Int, b: Int) = a + b

fun isDog(isDog: Boolean): Boolean {
    if (isDog) {
        return isDog
    } else {
        return isDog
    }
}

const val test2 = "1212"

class People constructor(name: String) {
    companion object {
        var id = 1
    }

    operator fun unaryPlus() = "this operator"
}