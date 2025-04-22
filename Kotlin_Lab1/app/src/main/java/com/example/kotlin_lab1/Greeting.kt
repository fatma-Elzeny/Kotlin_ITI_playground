package com.example.kotlin_lab1

fun main(){

    println("Enter your name")
    val name : String? = readLine()
    if(!name.isNullOrBlank()){

        println("Hello ${name}")
    }else {

        println("Hello Anonymous")
    }
    //println ("Hello  ${name ?: "Anonymous"}")

}