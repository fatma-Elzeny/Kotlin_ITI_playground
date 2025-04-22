package com.example.kotlin_lab4

fun main(){
   val rows =6

   for (i in 0 until rows) {
       for (j in 0..3 * rows) {
           if (j <= i) {
               print("*")
           } else if (j >= 2 * rows - i && j <= 2 * rows + i) {
               print("*")
           } else {
               print(" ")
           }
       }
       println()
   }
}