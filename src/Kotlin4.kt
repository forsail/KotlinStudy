/**
 * Created by Administrator on 2017/9/11.
 */
val lazyValue: String by lazy {
    println("first init")
    "Hello"
}

fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)
}