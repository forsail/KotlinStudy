import kotlin.reflect.KProperty

/**
 * Created by Administrator on 2017/8/17.
 */

fun main(args: Array<String>) {
//    study()
    delegateStudy()
}

//private var list: MutableList<String> = ArrayList()
//val p: String by lazy {
//    "test"
//}
//class Test {
//    lateinit var late: String
//}

fun delegateStudy() {
    var delegateA: String by Delegate()
    delegateA = "test"
    println(delegateA)
}

class Delegate {
    private lateinit var value: String

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return this.value
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        this.value = value
    }
}

//fun study(): Unit {
//    for (str in list) {
//        println(str)
//    }
//
//    for (index in list.indices) {
//        println(list[index])
//        println(list.get(index))
//    }
//    list.add("c")
//    println(list?.size ?: "empty")
//    list?.let {
//
//    }
//
//    val test = Test()
//    println(test.late)
//}