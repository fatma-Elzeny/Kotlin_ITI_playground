package com.example.calc

fun calculator(a: Double, b: Double, equation: (Double, Double) -> Double): Double {
    return equation(a, b)
}

// Define basic operations as functions
val add = { x : Double, y:Double -> x + y }
val subtract = { x: Double, y :Double -> x - y }
val multiply =  { x:Double, y:Double -> x * y }
val divide = { x:Double, y :Double->
    if (y != 0.0) x / y else 0.0
}

fun main() {
    val a = 10.0
    val b = 5.0

    println("Add: ${calculator(a, b, add)}")
    println("Subtract: ${calculator(a, b, subtract)}")
    println("Multiply: ${calculator(a, b, multiply)}")
    println("Divide: ${calculator(a, b, divide)}")
}