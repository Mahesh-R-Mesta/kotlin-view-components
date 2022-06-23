
var name = "mahesh"
val age:Int = 24


class Car(var name:String, var model:String, var year:Int ){
    fun drive(){
        println("$name model $model year $year");
    }
}



fun main() {
    val lastName:String = "mesta"
    val isMarried:Boolean = false
    var sugar:Double = 12.35567688
    var height:Float = 90.60F
    var mark:Char = 'A'
    var travelled: Long = 123434564
    var bite:Byte = 100
    var property:Short = 1234
    val myOs:String?
    myOs= "Ubuntu"
    println("Hello $name  $lastName and iam $age old")
    var msg = if(lastName.contains("mesta")) "belongs to mesta family" else "not belongs to mesta family"
    println(msg)
    val greet:String = welcome("mahesh",24)
    println(greet)

    var color = 3
    val selected = when(color) {
        1 -> "blue"
        2 -> "red"
        3 -> "green"
        else -> "black"
    }
    println(selected)
    checkLoop()
    var c =  Car("c20","Suzuki", 2017)
    println(c.model)
    c.drive()
    unitFun()
}


fun welcome(name:String,age:Int):String  {

    var result = if(age > 18 ){
         "Welcome Mr.$name your age is $age"
    } else {
         "Welcome kid $name"
    }
    return  result
}


 fun checkLoop(){
    var i = 0
    while(i<4){
        println("while:$i")
        i+=1
    }
    var array = arrayOf(1,2,3,4,5,6,7,8,9,0)
    for(a in array){
     println("for:$a")
    }
    if(8 in array){
        println("contain 8")
    }
    for(v in 5..9){
        println(v)
    }
    for(s in 'a'..'c'){
        println(s)
    }
}


fun unitFun(){
    var print:(Int) -> Unit={n:Int -> println(n)}
    print(10)
    var Sum:(Int,Int) -> Int={a:Int,b -> a+b }
    println(Sum(10,15))
}

fun test(sum:(Int,Int)->Int){
    sum(1,3)
}
