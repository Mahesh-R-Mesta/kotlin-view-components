import java.util.Scanner


fun main(args:Array<String>){
    var name:String?
    name = "sachin"
    var age = 23
    print("Enter Your Name: ")
    name = readLine()
    print("Enter Your age: ")
    age = Integer.valueOf(readLine())
    println("Role Number:")
    var role = Scanner(System.`in`);
    var number:Byte = role.nextByte()
    println("$name age: $age Role Number $number")
    val array:Array<Int> = Array(5,{i -> i*3 }) // array Class Object method 1 to create
    println(array.get(4))
    val array2 = arrayOf(1,2,3,4,5,6,7,8) // array Class Object method 2 to create
    array2.set(1,age)
    println(array2[1])
    var newAge:Byte = age.toByte()
    //Lambda is a function which has no name. Lambda is defined with a curly braces {} which takes variable as a parameter (if any) and body of function. The body of function is written after variable (if any) followed by -> operator.
    val customPrint:(String)-> Unit={w:String-> println("result: $w")} // lambda function
    nestedElseIf(2,2, customPrint)
    println("")
    whenSwitch(3)
    whenSwitch(7)
    whenSwitch(8)
    forLoop()
    recursiveFun()
    defaultparam(13)
    defaultparam(grade = 'B')
    hightOrder({a:Int, b:Int-> a+b})
    myInlineFun { println("Inline function get called")} // inline function
//    age.equals(newAge)

}


fun nestedElseIf(a:Int,b:Int,p:(String)->Unit): Unit { // Unit is similar to Void
    var restut = if(a >= b){
        var result2 = if (a == b){ // returns inter content
                "a and b are equal"
            } else {
                "a is greater than b"
            }
        "ans: $result2"
        }else {
        "a is lesser than b"
        }
    p(restut)
}

fun whenSwitch(num:Int){
    var result = when(num) {
        1->  "entered 1" // check condition
        2,3,4 -> "enterted 2,3,4 " // checks multiple conditions
        in 5..7 -> "entered 5/6/7"
        8 ->{
            """lucky number
               you chosen """
        }
        else -> "enter again"
    }
    println(result)
}

fun forLoop(){
    var arr:Array<Char> = arrayOf('A','B','C','D')
    print("Iterator:")
    for(a in arr){

        print(" $a,")
    }
    println("")
    print(" 5 downTo 1 step 2: ")
    for(a in 6 downTo 1 step 2){

        print(" $a,")
    }
    println("")
     for (i in 1..3) {
         loopName@for (j in 1..3) {
            println("i = $i and j = $j")
            if (i == 2)
                break@loopName
        }
    }
    for(i in 1..3) {
        label@for(j in 1..3){
            if(j==2) {
                continue@label
            }
            print(" i=$i ,j=$j ||")
        }
    }
}


//Recursion function is a function which calls itself continuously. This technique is called recursion.
//Tail recursion is a recursion which performs the calculation first, then makes the recursive call. The result of current step is passed into the next recursive call.
var ik = 0;
tailrec fun recursiveFun(){ //tailrect is used for recursive function to avoid failure(Exception in thread "main" java.lang.StackOverflowError) for large number of recursive callback
    ik++
    if (ik < 10) {
        println(ik)
        recursiveFun();
    }
}

//Kotlin provides a facility to assign default argument (parameter) in a function definition.

fun defaultparam(value:Int =12 ,grade:Char='A'){
    println("class $value grade: $grade")
}

//Higher order function >> passing function
fun hightOrder(multiply:(Int,Int)-> Int){
    var mul = multiply(12,14)
    println(mul);
}
 inline fun myInlineFun(callback:()->Unit){
     callback()
 }