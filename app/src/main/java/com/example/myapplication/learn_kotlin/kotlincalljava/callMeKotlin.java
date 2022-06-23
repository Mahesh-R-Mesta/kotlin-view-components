
package com.example.myapplication.learn.kotlincalljava;

import static com.example.myapplication.learn.kotlincalljava.CallMeJavaKt.circleArea;

public class callMeKotlin {
    public static void main(String[] args){
     System.out.println("java class created");
     double area = circleArea(12.0); // calling function from kotlin
     System.out.println("value: $area");
    }
    public static int area(int l, int b){
        return l * b;
    }
}
