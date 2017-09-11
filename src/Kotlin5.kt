import kotlin.properties.Delegates

/**
 * Created by Administrator on 2017/9/11.
 */
var name: String by Delegates.observable("init value") { prop, old, new ->
    println("$old -> $new")
}

fun main(args: Array<String>) {
    name = "hello"
    name = "hello2"
}