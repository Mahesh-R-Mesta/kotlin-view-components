

typealias Call = (String) -> Unit

fun main() {
    callMethod(object: Pass {
        override fun learn(a: Int, b: Int): Int {
            return a+b
        }

    })
}


fun interface Pass {
    fun learn(a:Int,b:Int):Int
}

fun callMethod(pass:Pass){
    val sum = pass.learn(12,23)
    println(sum)
}
