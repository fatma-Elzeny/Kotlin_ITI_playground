package com.example.coroutine

import kotlinx.coroutines.*

fun main() {
    runBlocking {
         launch {
            val deferred = async {
                for (i in 1..10) {
                    delay(500)
                    println(i)
                }
            }
            deferred.await() // Wait for the async block to complete
        }
    }
}