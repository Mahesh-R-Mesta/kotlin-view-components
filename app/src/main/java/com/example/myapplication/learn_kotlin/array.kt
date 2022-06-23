import java.lang.NumberFormatException

fun main(){
    array()
    string()
    exception()
}

fun array(){
    var myPrint:(String,String) -> Unit = {a,b -> println("$a: $b")}
    var array1:Array<Int> = arrayOf<Int>(1,3,4,5,6,7,7,8)
    var array3:Array<Int> = Array(5) { i -> i * 2 }
    var myArray:IntArray = IntArray(5,) { k -> k*3 }
    myPrint("intArray",myArray.toList().toString())
    var myCharArray: CharArray = CharArray(5) {k -> k.toChar()}
    myCharArray?.set(3,';')
    myPrint("charArray",myCharArray.toList().toString())
    var myString:Array<String> = arrayOf("saccha","abhya","venky","pakya","gannu")
    for(b in 0..myString.size-1){
        print(" ${myString[b]}")
    }
    myArray.size // print size of array
    myArray.equals(IntArray(2){i-> i})
    myArray.get(2)
    myArray.set(2,6)
    myArray.indices
    var a =  myArray.all { i -> i==0 }

    println(a)



}

fun string(){
    println("")
    val ch= charArrayOf('k','r','i','s','h','n','a')
    val sh = String(ch);
    sh.contains('A')
    sh.drop(1)
    println(sh.get(0))
    var full = sh.plus(" madusudana")
    var index = full.indexOfFirst { i -> i=='a' }
    println(index)
    full[0]
    println(full.count())
    println(full)
    var richText = """ 
        Hello world
        c201356
        hello world""".trimMargin()
    println(richText)
    //Referential equality (===)
    //To check the two different references point to the same instance, we use === operator.
    var str1 = buildString { "hello world" }
    var str2 = buildString { "hello world" }
    println(str1 === str2) // both instances are not same so false
    println(str1 !== str2) //both instances are not same so true

}


//ArithmeticException: thrown when we divide a number by zero.
//ArrayIndexOutOfBoundExceptions: thrown when an array has been tried to access with incorrect index value.
//SecurityException: thrown by the security manager to indicate a security violation.
//NullPointerException: thrown when invoking a method or property on a null object.

fun getNumber(str: String): Int{
    return try {
        Integer.parseInt(str)

    } catch (e: ArithmeticException) {
        println("arithmetic exception catch")
        0
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("array index outofbounds exception")
        0
    } catch (e: Exception) {
        println("parent exception class")
        0
    }
}

fun exception(){
    try {
        var value = 2/0;
        try {
            var l = arrayOf(0)
            l[1]
        } catch(e: ArrayIndexOutOfBoundsException ){
            println("array out of bound")
        }
    } catch (e:ArithmeticException){
        println("arithmetic Exception called")
    } finally {
        println("finally called always executed")
    }
    var a = getNumber("10.5")
    try {
        isUnderAge(20)
    } catch(e:ArithmeticException){
        println("arithmetic exception")
    }
}

fun isUnderAge(age:Int){
    if(age > 18){
        println("age is greater than 18")
    }else{
        throw ArithmeticException("not under age")
    }
}






// multiple try catch

//fun main(args: Array<String>){
//    try {
//        val a = IntArray(5)
//        a[5] = 10 / 0
//    } catch (e: ArithmeticException) {
//        println("arithmetic exception catch")
//    } catch (e: ArrayIndexOutOfBoundsException) {
//        println("array index outofbounds exception")
//    } catch (e: Exception) {
//        println("parent exception class")
//    }
//    println("code after try catch...")
//}