package com.example.kotlin_lab2

import kotlin.random.Random

fun main() {
    val size = 100
    val randomArray = IntArray(size) { Random.nextInt(1, 101) }
     for (i in randomArray.indices){
         if (randomArray[i]<= 10){

             println(randomArray[i])
         }

     }

}
