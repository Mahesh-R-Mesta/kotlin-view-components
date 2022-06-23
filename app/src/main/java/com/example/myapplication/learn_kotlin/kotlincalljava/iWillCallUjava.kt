@file:JvmName("iWillCallUMyJavaEx") // it will change the kotlin file name programmatically which can be used to denote file operation
@file:JvmMultifileClass
// u can use multiple kotlin files as one class file using this annotation. where ever we use this JvmName and JvmMultifileClass are all considered as one class
package com.example.myapplication.learn.kotlincalljava

import com.example.myapplication.learn.kotlincalljava.callMeKotlin


fun main(args: Array<String>){
   val area:Int = callMeKotlin.area(15,15) // calling from java code
    println("Java function Calculated Area: $area")
}
