




val aToz = 'a'..'z' // complete a,b,c,d.....z
val oneToTen = 1..10 // 1,2,3,4,5,6,7,8,9,10






////////////////////// Integral Type ///////////////////////////
// Integral type ranges (IntRange, LongRange, CharRange) are the ability to use in for loop.
fun kotlinRanges(){
    println("IntRange..")
    for(a in 1..10){
        print(" $a")
    }
    println("\ncharRange..")
    for(b in 'a'..'c'){
        print(" $b")
    }
    println("\nlongRange")
    val range = 1.0..3.0
    println(range)
}

/*Kotlin range of integer
Let's see an example of integer range using downTo(), downTo, and rangeTo() methods.*/

fun kotlinRangeInteger(){
    println("\na in 3 downTo 1 :")
    for(a in 3 downTo 1){
        print(" $a")
    }
    println("\nb in 4 downTo 0 step 2 :")
    for (b in 4 downTo 0 step 2){
        print(" $b")
    }
    println("\nc in 3 until 5 :")
    for(c in 3 until 5){
        print(" $c")
    }
    println("\ne in 4 until 10 step 2 :")
    for(e in 4 until 10 step 2){
        print(" $e")
    }
    println("\ne in 4.rangeTo(10) : ")
    for(e in 4.rangeTo(10)){
        print(" $e")
    }
    println("\nf in 2.downTo(5) : ")
    for (f in 5.downTo(3)){
        print(" $f")
    }

    val r = 'a'..'f'
    val iter = r.iterator()
    while(iter.hasNext()){
        val value = iter.next()
        println(value)
    }
    //This is done by using in or !in operators.
    if(5 !in 1..4){
       println("5 is not in 1..4")
    }
    if(4 in 1..4){
        println("4 is in 1..4")
    }
}
// Kotlin Utility Functions :: kotlin range utility function have several standard library which are used in kotlin ranges
/* rangeTo()
* downTo()
* reversed()
* step() */

var range = 1.rangeTo(10)
var down = 5.downTo(10)
var reverse = (1..4).reversed()

fun rangeToFun(){
    val range:IntRange = 1.rangeTo(20)
    println("range: $range")
    val range2:IntRange = IntRange(2,5)
    println("rangeInt: $range2")
}

fun downToFun() {
    val range = 1 downTo 4
    val rangeTo = 1.downTo(5)
    val intProg = IntProgression.fromClosedRange(5,1,-1)
    println(range)
    println(rangeTo)

}

fun reverseFun(){
    val list = IntProgression.fromClosedRange(1,5,1)
    list.reversed()
    println(list)
}


fun main(){
    kotlinRanges()
    kotlinRangeInteger()
    rangeToFun()
    downToFun()
    reverseFun()
}


/*
////////////////////////////// Working of ranges /////////////////////////////////

Ranges implement ClosedRange<T> a common interface in the library. It represents a closed mathematical interval defined for comparable types. It contains two endpoints as start and end (endInclusive)points. The operation performed in range is to check whether the element is contained in it or not. This is done by using in or !in operators.

An arithmetic progression is represented by integral type progressions such as CharProgression, IntProgression, Long Progression. Progressions represent the first element, the last element and the step which is non-zero. The first element is first, sub-sequent elements represent previous element plus step and the last element is the last element unless progression is completed.

Progression refers to subtype of Iterable<N>, where N is Char, Int or Long. As progression is Iterable<N> type it can be used in for-loop and function such as filter, map etc.

The . .operator creates an object for integral type which implements both ClosedRange<T> and Progression. For example, a range type LongRange implements ClosedRange<Int> and extends Long Progression, it means all the operation which are defined for LongProgression is also available for LongRange. The output generated by downTo() and step() functions is always a Progression.

The last element of the Progression is largest value not greater than the end value for positive step. The minimum value of progression is not less than the end value for negative step. The last value is checked by using (last-first) %step == 0.*/