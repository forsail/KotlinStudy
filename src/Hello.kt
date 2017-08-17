import javax.rmi.CORBA.Util
import kotlin.comparisons.naturalOrder
import extension.testExtensionOutSide

/**
 * Created by lihong on 2017/3/17.
 */
fun main(args: Array<String>) {
    var a: Int = 1;
    var b = 2;
    val c: Int = 3;
    val s: String = "testWhen";
    println(add(a, b));
    println("Hello World");
    testWhen(s);
    testSudent()
    nullTest(myStr)
    testIn(1)
    println(testNull(null))
}

fun add(a: Int, b: Int): Int {
    return a + b;
}

fun add2(a: Int, b: Int) = a + b

fun test(a: Int): Unit {
    println("test");
}

fun test2(a: Int) {
    println("test2");
}

fun test3(a: Int) = println("test3")

fun max(a: Int, b: Int) = if (a > b) a else b;


fun testWhen(n: Any) {
    when (n) {
        is String -> {
            println("string");
        }
        is Int -> {
            println("int");
        }
        "hello" -> {
            println("this is hello")
        }
        else -> {
            println("other");
        }
    }
}

fun testFor(a: Int): String {
    for (a in 90..100) {
        return "goood";
    }
    return "not so bad";
}

fun test4(a: Int) {
    a + 4
}

fun strTest(str: String, strs: Array<String>) {
    println("string:$str strings:${strs[0]}")
}

class Student(var name: String, age: Int, college: String?) : Person(age) {
    override fun personFun() {
        println("student")
    }

    init {
        val collegeCopy: String? = college
    }

    var prop: String? = null
        set(value) {
            field = value
        }

    //age未申明，只能作为声明属性和初始化模块使用
    var ageCopy = age

    //name已申明可作为全局变量使用
    fun outStr() {
        println("method outStr:$name")
//        println("method outStr:$collage") error
    }

    companion object {
        var NAME = "companion test"
    }
}

fun print() {
    print("my test")
}

open class Person(val age: Int) {
    open fun personFun() {
        println("person")
    }
}

fun testSudent() {
    var stu = Student("asher", 22, "nanjing");
    stu.outStr()
    println("method testStudent:${stu.name}")
    println("method testStudent:${stu.age}")
    stu.personFun()
    stu.testExtensionOutSide("outside")
    stu.testExtenSionInside("inside")
    println(Student.NAME)
}

var myStr: String? = "hi";
fun nullTest(str: String?) {
    if (str == null) {
        println("myStr is null")
    } else {
        println(str.length)
    }
}

//只读列表，即使声明为var
private val list = listOf<String>("a", "b")

fun Student.testExtenSionInside(str: String) {
    println("extension test inside:$str")
}

fun testIn(a: Int?) {
    if (a in 1..10) {
        println("ok")
    } else {
        println("no")
    }
}

fun testNull(a: String?): Int {
    return a?.length ?: 0
}

fun <T, R> List<T>.map(transform: (T) -> (R)): List<R> {
    val result = arrayListOf<R>()
    for (item in this) {
        result.add(transform(item))
    }
    return result
}

val <T> List<T>.lastIndex: Int
    get() {
        return size - 1
    }
