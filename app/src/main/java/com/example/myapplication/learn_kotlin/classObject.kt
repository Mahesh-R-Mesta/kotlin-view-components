
/////////////////// kotlin Class & Nested Class & Inner Class ////////////////////////////////
class ClassObject { // empty constructor
    private var id:Int = 5
}

class ClassCon constructor(var name:String) { //class with constructor or ClassCon(var name:String)
    private var classType = "Parent Class"

    class NestedClass {   // nested Class in kotlin // Nested class is such class which is created inside another class
        //nested class can't access outer class variables
        private var type = "it's a nested class"
        fun type() = println(type)
    }

    //nested class with inner keyword
    // inner key declared class can access private member of outer class
     inner class InnerClass {
        var description:String = "innerClass Can access outerClass properties $name"
        fun whoMyParentClass(){
            println(classType)
        }
    }

}

////////////////////////// Kotlin Constructor //////////////////////////////////////
//There are two types of constructors in Kotlin:
//      1) Primary constructor
//      2) Secondary constructor
//
//         1) Primary constructor
//The primary constructor does not contain any code. Initializer blocks are used to initialization of code.
class PrimaryConstruct(val name:String, var id:Int){ // This is a Primary constructor
    private var myName:String =""
    private var myId:Int = 1

    // initializer block (use if required)
    init { // with initializer block it a optional
        myName = name.lowercase()
        myId = id
    }
    fun show() = println("name $myName id:$myId")
}

//    2) Secondary constructor
// In Kotlin, secondary constructor can be created one or more in class. The secondary constructor is created using "constructor" keyword.
class SecondaryConstructor {
    var name:String = ""
    private var myId:Int= 0
  constructor(name:String, userId:Int) {  // first Secondary Constructor
      this.name = name
      this.myId = userId
  }
    constructor(name:String,userId: Int,password:String){  // second Secondary Constructor
        this.name = name
    }
}

class SecondaryConstructOne(password:String) {
    var userName:String? = null
    var userPass:String? = null
    constructor(userName:String, password: String): this(password){
         println("SecondaryConstructOne is created calling constructor $password")
    }
}

// constructor calls another constructor
// Calling one secondary constructor from another secondary constructor of same class
class SecondCallsSecondConst {
    constructor(password: String):this("default_user",password,"example@gm.com"){ // calling constructor at last
        println("first constructor called $name")
    }
    constructor(name:String,password: String,email:String){  // first this constructor is called
        println("second constructor called $name $password $email")
    }
}

////////////////////////////////// Inheritance /////////////////////////////////////////////

open class Parent {
    constructor(name:String,age:Int):this(name,age,"NA"){

    }
    constructor(name:String,age:Int,birthDate:String){

    }
}

class Child1(name: String, age: Int) : Parent(name, age) {

}

class Child2:Parent {
    constructor(name: String, age: Int):super(name, age){

    }
    constructor(name:String,age:Int,birthDate:String):super(name,age,birthDate){

    }
}

/////////////////////////// visibility modifier //////////////////////////////////////
//In Kotlin, visibility modifiers are categorized into four different types:
//  1) public
//  2) protected
//  3) internal
//  4) private

////////////////// public /////////////////////////
/*A public modifier is accessible from everywhere in the project. It is a default modifier in Kotlin.
If any class, interface etc. are not specified with any access modifier then that class, interface etc. are used in public scope.*/

public class Declared {
    public val pub = 10
    public fun publicFun(){
        println("Publicly available function")
    }
}

 class ByDefaultPublic {
     val pub = 10
     fun publicByDef(){
        println("Publicly available function")
    }
}

//////////////// protected //////////////////////
// protected modifier with class or interface allow visibility to only is class and subclass
open class ProtectedParent {
    protected val id = 0 // id available in class
}

class Derived:ProtectedParent() {
 fun getValue() = id // id is available in parent class
}

///////// overriding protected type ////////////////
//
open class ProtectedParent2 {
    open protected val value =102
}

class ChildParent:ProtectedParent2() {
    fun getValue(){
        // cannot return value hence it is protected
    }
    override val value = 123
}

////////////internal modifier ///////////////////////////
// The internal modifier makes the field visible only inside the module in which it is implemented.

internal class ExampleInternal { // cannot use it for inheritance with child class
    internal val value = 5
    internal fun getValue() {
        println("value is $value")
    }
}

//class ChildInternal: ExampleInternal() { // invalid
//
//

//////////////////private modifier //////////////////////////
/*A private modifier allows the declaration to be accessible only within the block in which properties, fields, etc.
 are declare. The private modifier declaration does not allow to access the outside the scope. */

private class Private {
    private val value = 125
    private fun getValue() {
        //cannot return value hence it is private
    }
}


fun classModifiers() {
    var private = Private()
    // not visible >> private.value & private.getValue
    val internals = ExampleInternal()
    internals.value
    internals.getValue()
    var protected = ProtectedParent2() // override
    // not visible >> protected.value
    var pro = ProtectedParent() // id available in class
    // pro.value >> not visible
}
////////////////////////////////////// Inheritance /////////////////////////////////////////////////////
// Inheritance allows to inherit the feature of existing class (or base or parent class) to new class (or derived class or child class).

// open key word is used to declare the class is going to be inherited, because in kotlin class are final by default
// function should be open if ypu want to override that function in child class
open class Employee(name:String, id:Int, role:String) {
    var name:String? = null
    var id:Int? = null
    private var role:String? = null
    open var isWorking:String = "yes he is working"
    init {
        this.name = name
        this.id = id
        this.role = role
    }
     open fun showAllDetail(){
        println("employee name: $name")
        println("id: $id")
    }
    fun whois(){
        println("am employee $role")
    }
}

class Programmer(name:String, id:Int):Employee(name,id,"programmer") {
    override var isWorking: String = "Some time he works" // override property
    // Property of superclass can also be overridden in its subclass  as similar to method.
     override fun showAllDetail(){ // to override this method u need to put open in the parent class method
        println("i am programmer $name\n yoo-id:$id")
        println("is he working: $isWorking")
        super.showAllDetail()
    }
}
/////////////// 222
open class Animal(name:String) {
    open fun bark(){
        println("barrr barrr")
    }
}

interface Domestic { // interface is like extension in kotlin
    fun petName(name:String){
        println("pet name is :$name")
    }
    fun bark(){
        println("Meoo MeOO")
    }
    fun cute() // u can declare empty function as like abstract method to implement method in child class
}

class Dog(name:String ,petName:String): Animal(name),Domestic {
 init {
     petName(petName)
 }
    override fun bark(){
        super<Domestic>.bark()
        super<Animal>.bark()
        println("Baoo Baoo")
    }

    override fun cute() {    // should be declared inorder to
        println("Nooooooo")
        TODO("Not yet implemented")
    }
}
////////////////////////////////////// Abstract Class Inhertance //////////////////////////////////////////////////

abstract class Bank {
    abstract var savingAmount:Int // abstract variable
    abstract fun simpleInterest(interest:Int) // abstract function
}

class CanaraBank: Bank() {
    override var savingAmount: Int = 0  // abstract variable
    override fun simpleInterest(interest: Int) {  // should implement the app
        TODO("Not yet implemented")
    }
}

//// examole 2
open class GrandParent {
    open fun whoami() = println("GrandParent class")
}
abstract class ParentClass: GrandParent() {
    override fun whoami() {
        println("Parent Class")
        super.whoami()
    }
    abstract fun greet():String
}
class Child:ParentClass() {
   override fun whoami(){
       println("Child Class")
       super.whoami()
   }
    override fun greet(): String {
        TODO("Not yet implemented")
    }
}


/////// abstract class inheritance

fun inheritanceClass() {
    println("------------ Inheritance ---------------")
    val man = Programmer("mahesh", id = 1998)
    man.whois()
    man.showAllDetail()
    println("${man.name} ${man.id} ")
    val animal = Dog("domestic", petName = "rocky")
    animal.bark()
    val child = Child()
    child.whoami()
}
///////////////////////////////////// Interface /////////////////////////////////////////////////////
// kotlin interface is the blueprint of class.Kotlin interface is similar to java 8

interface MyInterface {
    var int:Int // abstract property
    fun abstractClass() // abstract method
    fun start(){
        println("Stared First")
    }
}

interface MySecondInterface {
    fun secondAbstract()
    fun start() {
        println("Stared Second")
    }
    fun doSomething(){
        println("")
    }

}
/*We can implement multiple abstract methods of different interfaces in same class. All the abstract methods must be implemented in subclass.
 The other non-abstract methods of interface can be called from derived class.*/
class NewInterfaceClass:MyInterface, MySecondInterface { // multiple inheritance of interfaces

    override var int: Int = 12
    override fun abstractClass() {
        println("1 abstract interface inherited class")
    }
    override fun secondAbstract() {
        println("2 abstract interface inherited class")
    }

    override fun start() {
        print("inherited Class")
        super<MyInterface>.start()
        super<MySecondInterface>.start()
    }
}

fun myInterface(){
    val inter = NewInterfaceClass()
    inter.doSomething() //non-abstract methods of interface can be called from derived class
    inter.start()
    inter.abstractClass() //abstract method

}
////////////////////////////// data class //////////////////////
// data class is a simple class which hold the data/state and contain standard functionality. it is used to declared class as data class

data class User(var name:String, val employeeId:Int, var email:String) // data class


fun dataclassTest(){
   val user1 = User("swamy k", 2022, email = "sachin@swamyk.com")
    val user2 =  User("sachin swamy", 2022, email = "sachin@IPS.com")
    println(user1)
    println(user2 == user1) // false
    var user3 = user2.copy()
    println(user3 == user2) // true

    user3 = user1.copy(name="abhishek")
    println(user3)
    print(user2.component1()) // gives first variable name
    print(user2.component2()) // gives first variable id
}
//////////////////////////// sealed class /////////////////////////////////////////
// sealed class restrict the class hierarchy (organisation)
// A class can be declared as sealed class using "sealed" keyword before the class name. It is used to represent restricted class hierarchy.
// Sealed class is used when the object have one of the types from limited set, but cannot have any other type.Sealed class is used when the object have one of the types from limited set, but cannot have any other type.s
// use when u have to inherit one class for may other subclasses then use sealed class
sealed class Shape {
    // The subclasses of sealed classes must be declared in the same file in which sealed class itself.
    init {
        println("Sealed class is declared")
    }

    class Circle(val radius:Float):Shape() {
        class ParagolaCircle:Shape()
    }

    class Triangle(val base:Float,val height:Float):Shape() {

    }
    class Rectangle(val base:Float,val height:Float):Shape()
    object NotAShape:Shape()
}

//// example 2
//Sealed class ensures the important of type-safety by restricting the set of types at compile time only.
sealed class A {
    class B:A() {
        class C:A() // this works in sealed class
    }
    class D:A()
}

// invalid
class D:A() {
    class F:A()  //This won't work,because sealed class is defined in another scope.
}

// example 3 //////////  sealedClass with when  ////////////////////

fun evaluate(e: Shape){
    val whichOne = when(e){
        is Shape.Circle -> "It is a Circle Object"
        is Shape.Triangle -> "It is a Triangle Object"
        is Shape.Circle.ParagolaCircle -> "It is a ParabolaCircle Object"
        else -> "not found"
    }
    println(whichOne)
}


fun sealedClass() {
    // var shape = Shape()  sealed class cannot be instantiated
    val circle = Shape.Circle(radius = 10.5F)
    val para = Shape.Circle.ParagolaCircle()
    val tri:Shape.Triangle = Shape.Triangle(12.0F,20.0F)
    val rect = Shape.Rectangle(10.2F,10.3F)
    evaluate(tri)
    evaluate(para)
    var a = D.F()

}

//////////////////// class extension Function ////////////////
/*extension function allow us to add the class method without touching the class code
  fun<Class_NAME>.<Function_NAME>()  */

class Student {
    fun isPassed(mark:Int):Boolean {
        return mark > 30;
    }
}
// extension method
fun Student.isExcelent(mark:Int):Boolean {
    return mark > 90
}

// nullable extension
fun MutableList<Int>?.swap(index1:Int,index2:Int): MutableList<Int>? {
    if(this == null) return null
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
    return this
}
//Companion Object
class ComObject {
    companion object {
        fun createNew(){
            println("Created new one")
        }
    }
}

// companion object extension example
fun ComObject.Companion.callNewExtension(){
    println("Called new extension method")
}

fun checkClassExtension(){
    val student1 = Student()
    val isPassed = student1.isPassed(40)
    val isExcel = student1.isExcelent(95)
    println("is passed: $isPassed  is Excelent $isExcel")
    val list = mutableListOf<Int>(1,2,3,4,5,6,7)
    list.swap(2,3)
    println("swape: $list")
    ComObject.createNew() // called companion object function
    ComObject.callNewExtension() // called new added extension
}

////////////////////// Generic Type ///////////////////////////
/*Generics are the powerful features that allow to define classes, methods, and properties etc. which can be accessed using different types.
 The type differences of classes, methods, etc. are checked at compile-time.*/
/* ///////////////// Advantage ////////////
  * TypeSafe: Generic allow us to hold single type of Object
  * Type Casting is not required
  * Generic code compiles at run time gives issue if any */

class PersonAge<T>(age:T){
    private var myAge:T = age
    init {
        println(myAge)
        print("is type of: ")
        if(myAge is String){
          println("String")
        } else if(myAge is Int){
            println("Int")
        }
    }
}



fun genericType(){
 var myAgeInt = PersonAge<Int>(30)
 var myAgeStr = PersonAge<String>("30")
 var list:MutableList<Int> = mutableListOf<Int>(1,2,3,4,5,6) // this takes Generic type in kotlin
}


fun main() {
    var construct = ClassCon("Rocky")
    val nestedClass = ClassCon.NestedClass()
    nestedClass.type()
    val innerClass = ClassCon("Jimmy").InnerClass()
    val msg = ClassCon("ruby").InnerClass().description
    innerClass.whoMyParentClass()
    println(msg)
    //////////////////////////////////
    val primary = PrimaryConstruct("goutham",23)
    primary.show()
    var secondaryConstructor = SecondaryConstructor(userId = 123, name = "Hello") // first constructor
    var secondaryConstructor2 = SecondaryConstructor(userId = 123, name = "hello", password = "123#4$#@") // first constructor
    val secondaryConstructOne = SecondaryConstructOne(password = "OnlyPassword") // don't calls constructor
    val secondaryConstructOne2 = SecondaryConstructOne(userName = "hello" ,password = "OnlyPassword") // calls constructor
    val secondCallsSeconds = SecondCallsSecondConst(password = "123455") // second constructor first,  first constructor called last
    classModifiers() // visibility modifier
    inheritanceClass() // inheritance
    myInterface() // interface
    dataclassTest() // data class
    sealedClass() // sealed class
    checkClassExtension() // extension
    genericType() // generic type
}
