package com.example.factorial

import kotlinx.coroutines.*

// Suspend function that calculates factorial using async
suspend fun calculateFactorial(n: Int): Long = coroutineScope {
    val job = async {
        var result = 1L
        for (i in 1..n) {
            result *= i
            delay(100)
        }
        result
    }
    job.await()
}

// Main function to test the factorial calculation
fun main()

{
    runBlocking {
        val number = 5
        val factorial = calculateFactorial(number)
        println("Factorial of $number is $factorial")
    }
}
