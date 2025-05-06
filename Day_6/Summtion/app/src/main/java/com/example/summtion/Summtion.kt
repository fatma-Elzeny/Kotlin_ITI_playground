package com.example.summtion

import kotlinx.coroutines.*

suspend fun sumArrayElements(arr: IntArray): Int = coroutineScope {
    var sum = 0
    for (num in arr) {
        delay(100) // Simulate a small delay per element
        sum += num
    }
    sum
}

fun main() {
    runBlocking {
        val numbers = intArrayOf(1, 2, 3, 4, 5)
        val total = sumArrayElements(numbers)
        println("Sum of array elements: $total")
    }
}
