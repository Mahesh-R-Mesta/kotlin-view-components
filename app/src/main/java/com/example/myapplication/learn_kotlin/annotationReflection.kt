


var x = 5
class Model(val y:Int)

fun main(){
    /*Reflection is a set of language and library features that examines the structure of program at runtime. Kotlin makes functions and
     properties as first-class citizen in the language and examine these functions and properties at runtime.*/
    classReference()
    functionReference()
    overloadFunctionalReference()
    propertyReference()
    classPropertyReference()
    //Access the property of member class:
}



fun classReference(){
    //Class Reference
    //Class reference is used to obtain the reference of KClass object. To obtain the reference of statically Kclass,
    println("CLASS REFERENCE")
    val c1 = String::class
    println(c1)
}

fun functionReference(){
    //Kotlin functional is used to obtain the reference of function using double colons. The reference of function can be used in another function as a parameter.
    println("FUNCTIONAL REFERENCE")
    fun isPositive(int:Int) = int >= 0
    val array:List<Int> = listOf<Int>(1,2,-3,4,-5,6,-7)
    array.filter(::isPositive) // functional reference
    println(array)
}

fun overloadFunctionalReference(){
    // The operator :: can be used with overload function when the expected type is known from the context.
    println("OVERLOAD FUNCTIONAL REFERENCE")
    fun isPositive(int:Int) = int >= 0
    fun isPositive(str:String) = str.lowercase() == "positive"

    val arrayInt:ArrayList<Int> = arrayListOf(1,2,3,4,-8,-6,-2,-5)
    val arrayStr:Array<String> = arrayOf("positive","negetive")

    arrayInt.filter(::isPositive) // it checks for expected type of array
    arrayStr.filter(::isPositive)
    println(arrayInt)
    println(arrayStr)
}



var xy = 5
fun propertyReference() {
//We can also access the properties as first-class object in Kotlin, to access object property we can use :: operator:
//To evaluate the property object of type KProperty<Int> we use the expression ::variableName. The expression ::variableName allow to retrieve its property name by using name and readits value using get() function.
println("PROPERTY REFERENCE")
    println(::xy.get())
    println(::xy.name)
    println(::xy.set(10))
}

class Object(var name:String, var isLiving:Boolean)

fun classPropertyReference(){
    println("CLASS PROPERTY REFERENCE")
    val props = Object::name

    val newObj =  Object("table", isLiving = false)

    val e = props.get(newObj)
    println(e) // table

}


@Target(AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class Testing


class MyClass constructor(){

}