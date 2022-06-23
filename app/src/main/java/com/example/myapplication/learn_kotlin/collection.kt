import android.os.Build
import androidx.annotation.RequiresApi
import java.util.HashMap

fun main(){
    arrays()
    collectionList()
}

fun arrays(){
    var array:Array<Int> = arrayOf<Int>(1,2,3,4,5,6,7,8,9)
    var array2:IntArray = IntArray(5) { i -> i * 2 } // [0,2,4...10]
    //charArray, strArray ,intArray, strArray, byteArray, longArrayOf, shortArrayOf, booleanArrayOf,  floatArrayOf(), doubleArrayOf

    var strArray:Array<String> = arrayOf<String>("hello","my","dear","....")
    var mixture:Array<Any> = arrayOf(1,'2','f','F',4,6,"asdsd")
    var intArray = Array(5) {i -> i*4} // [0,4,8,12...20]
    var array3 = Array(5){0}
    array3[0] = 10
    array3[4] = 15
    for(a in array3){
        println(a)
    }
    for(value in 0 until mixture.size){
        print(mixture.get(value))
        print(" ,")
    }
    for(value in 0..mixture.size-1){
        print(mixture.get(value))
        print(" ,")
    }
}



// Kotlin collection
//Collections in Kotlin are used to store group of related objects in a single unit. By using collection, we can store, retrieve manipulate and aggregate data.

//Kotlin collections are broadly categories into two different forms. These are:
//
//1) Immutable Collection (or Collection)
//2) Mutable Collection



//////////////////////////////////////immutable collection //////////////////////////

//Immutable collection also called Collection supports read only functionalities. Methods of immutable collection that supports read functionalities are:
//
//Kotlin list interface
//def: Kotlin List is an interface and generic collection of elements. The List interface inherits form Collection<T> class. It is immutable and its methods supports only read functionalities.
// def-code: public interface List<out E> : Collection<E> {......}

fun immutableList(){
 var list:List<Int> = listOf<Int>(1,2,3,4,5,6,7,8,9) //read only, fix-size
 var mixture:List<Any?> = listOf<Any?>(1,2,'A','B',"hello",null) //read only, fix-size
 print(mixture.get(0))
    print(mixture.indexOf("hello"))
    print(mixture.lastIndexOf("vijaya"))
            println(mixture.size)
            println(mixture.contains("Prakash"))
            println(mixture.containsAll(list))
            println(mixture.subList(2,4))
            println(mixture.isEmpty())
            println(mixture.drop(1))
            println(mixture.dropLast(2))
}

/*def: Kotlin Map is an interface and generic collection of elements. Map interface holds data in the form of key and value pair. Map key are unique and holds only one value for each key.
fixed size and its methods support read only access.*/

fun immutableMap(){
    println("------immutable map----------")
    var map = mapOf<Int,String>(1 to "abhishek", 2 to "sachin",3 to "venky") // only read,size
    println(map)  // only read,size
    var map2 = mapOf<String,String>("name" to "sachin", "age" to "23", "company" to "codematrix") //this is generic // only read,size
    var map3 = mapOf("1" to "hello", "2" to 2) // this is non-generic
    print(map2.size)
    map2.getValue("name")
    map2.containsKey("name")
    map2.containsValue("sachin")
    for(a in map2.keys){
        print(" $a : ${map2[a]}")
    }
    var new  = map.plus(Pair(4,"pakkya")) // hence map can be read only so it wont change anything in existing map
    map.getOrDefault(1,3) // get value @ key 1 if not exist default
    map.minus(4) // remove value @key
    map.iterator() // itertator  each obj.key & key.value
    println("------end immutable map----------\n")
}

/*Kotlin Set interface is a generic unordered collection of elements. Set interface does not support duplicate elements.
This interface is immutable in nature its methods supports read-only functionality of the set.*/
//interface Set<out E> : Collection<E> (source)

fun immutableSets(){
    var sets:Set<Any> = setOf(1,2,3,4,'a','b',"hello")
    sets.size
    sets.contains(2)
    sets.containsAll(setOf(1,3,2))
    sets.iterator()
    println(sets.filter { i -> i==2 })
    print(sets.drop(1))
    sets.first()
    sets.isEmpty()
    sets.isNotEmpty()

}


//////////////////immutable collection end /////////////////////////////////////////////////



/////////////////////////////mutable collection////////////////////////////////////////
//Mutable collections supports both read and write functionalities. Methods of mutable collections that supports read and write functionalities are:
/*Kotlin MutableList is an interface and generic collection of elements. MutableList
 interface is mutable in nature. It inherits form Collection<T> class. The methods of MutableList interface
 supports both read and write functionalities. Once the elements in MutableList have declared, it can be added more elements in it or removed, so it has no fixed size length.*/


fun mutableLists(){
    var mutable = mutableListOf<Int>(1,2,3,45,6,7,8,9) // read and write
    var mutable1 = mutableListOf<String>("hello","sachin","swamy") // read and write
    mutable1.add("the great man")
    mutable1.remove("hello")
    print(mutable1)
    for(a in mutable){
        print(" $a")
    }
    println("")

}

fun mutableSets(){
    println("------------- mutableSetOf---------------- ")
    var sets:MutableSet<String> = mutableSetOf<String>("hello","mahesh","mesta")
    var sets2 = mutableSetOf<Any?>(1,'A',2,3,4,5,"sachin")
    sets.contains("mahesh")
    sets.remove("hello")
    sets.isEmpty()
    sets.isNotEmpty()
    sets2.drop(1) // return sets removing 1 index
    sets.add("welcome")
    sets.indexOf("welcome")
    sets.first()
    var d = sets.iterator()
    var a = sets.find { i -> i == "mahesh" }
    println(a)
}

fun hashSets(){
    println("\n-------- hashSet map ----------")
    var hashSet:HashSet<String> = HashSet<String>() // HashSet
    var hasSet2:HashSet<Int> = hashSetOf(1,2,3,4,5,6,7,8,4)  //hashSetOf
    hashSet.add("hello ")
    hashSet.add("kotlin ")
    hashSet.add("how old are you")
    hasSet2.drop(2)
    hasSet2.add(5)
    var v = hashSet.reduce { acc, s -> acc+s }
    println(v)
    for(l in hasSet2){
        print(" $l")
    }
}

/*A hashMapOf() is a function of HashMap class. It returns a new HashMap with the specified contents. It contains pairs of data in the form of key and value.
HashMap is mutable collection which provides both read am write functionalities.*/
fun mutableHashMap() {
    println("------mutable hashmap----------")
    var map:HashMap<Int,String> = hashMapOf<Int,String>( 1 to "krishna", 2 to "madhava", 3 to "acchuta")
    var anyMap:HashMap<Any,Any?> = hashMapOf<Any,Any?>("1" to "kotlin", 3 to "sachin", "kotlay" to "abhya" )
    map.put(4,"govidha")
    map.getOrDefault(1,2)
    map.keys // all key
    map.getValue(1)
    anyMap.set("kotlay","sachin") // update
    anyMap.remove("kotlay")
    map.size //size
    println("------non mutable hashmap----------")
    mutableMaps()
}


//Kotlin MutableMap is an interface of collection framework that holds the object in the form of key and value pair.
fun mutableMaps(){
    println("--------mutableMapOf----------\n")
    var map:MutableMap<String,Any> = mutableMapOf<String,Any>("name" to "mahesh", "age" to 24, "isSingle" to true)
    map.set("isSingle",true)
    map.containsValue("mahesh")
    map.containsKey("name")
    // all the methods count(), clear(), getOrDefault(),getValue,get(Key),contain(), containValue(),containKey
    println("------mutableMapOf END----------")
}


/*Kotlin ArrayList class is used to create a dynamic array. Which means the size of
ArrayList class can be increased or decreased according to requirement. ArrayList class provides both read and write functionalities.*/
fun myArrayList(){
    var array = ArrayList<String>()
    var array2 = ArrayList<String>(6) // size of array
    array.add("name")
    array.add(": abhishek")
    var iter = array.iterator()
    while(iter.hasNext()){
        print(iter.next())
    }
    var array3 = arrayListOf<Int>(1,2,3,4,5,6)
    array3.first()
    class Emmployee(val name:String, val id:Int)
    var employees = arrayListOf<Emmployee>()
    employees.add(Emmployee(name = "sachin", id = 420))
}




////////////////////////end mutable collection ////////////////////////////////////////

fun collectionList(){
    immutableList()
    mutableLists()
    myArrayList()
    immutableMap()
    mutableHashMap()
    immutableSets()
    mutableSets()
    hashSets()
}