import extension.testExtensionOutSide

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
}

const val test2 = "1212"

class People constructor(name: String) {
    companion object {
        var id = 1
    }
}