import java.lang.IllegalArgumentException
import java.util.*

fun main(){
    var name:String? // nullable type
    val age:Int = 1 // non nullable type
    var value = Scanner(System.`in`)
    name = value.toString();
    smartCast()
    safeUnsafeCast()
    elvisOperator()

}

fun safeUnsafeCast(){
    // sometime its not possible to cast a variable which throws exception is called unsafe cast

    // wrong casting
    try {
        var name:Any? = null
        // unsafe cast operator
        var str:String = name as String
    } catch (e:NullPointerException){
        println("unsafe cast operator")
    }

    // nullable casting
    var name2:Any? ="asasdsad"
    var str2:String? = name2 as String?

    //Kotlin provides a safe cast operator as? for safely cast to a type. It returns a null if casting is not possible rather than throwing an ClassCastException exception.

    // this is known as safe casting
    var name3:Any? = "hello"
    var str3: String? = name3 as? String
    var int: Int? = name3 as? Int
    println("$str3  $int")
}



fun smartCast(){
    //Smart cast is a feature in which Kotlin compiler tracks conditions inside if expression. If compiler founds a variable is not null of type nullable then the compiler will allow to access the variable.
    if(name!=null){  // smart cast
        println(name)
    }
    if(name is String){ // smart cast
        println(name)
    }
    if(name !is String){// smart cast
        println(name)
    }
}

//Elvis operator (?:) is used to return the not null value even the conditional expression is null. It is also used to check the null safety of values.
fun elvisOperator(){
    var fname:String? = null
    var lname:String? = "non null"
    var flength:Int = fname?.length?:0
    var len:Int? = lname?.length?:0
    var fullname:String = (fname?:"NA") + (lname?:"")
    println(fullname)

    // throw exception
    try{
        var nonnull:String? = fname?:throw IllegalArgumentException("Illegal Args exception: first name is null")

    } catch (e: IllegalArgumentException){
        println(e.message)
    }

}