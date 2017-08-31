/**
 * Created by Administrator on 2017/8/30.
 */
fun main(args: Array<String>) {
    nullTestFun("shabi")
}

fun nullTestFun(str: String) {
    println(str?.length)
}