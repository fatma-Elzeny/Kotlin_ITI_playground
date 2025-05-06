package com.example.canselation

import kotlinx.coroutines.*

fun main() {
    runBlocking {

        // Launch first coroutine
        val job1 = launch {
            try {
                repeat(1000) { i ->
                    println("Coroutine 1: working on task $i")
                    delay(1000)
                }
            } catch (e: CancellationException) {
                println("Coroutine 1 was cancelled.")
            }
        }

        // Launch second coroutine
        val job2 = launch {
            try {
                repeat(1000) { i ->
                    println("Coroutine 2: processing item $i")
                    delay(1000)
                }
            } catch (e: CancellationException) {
                println("Coroutine 2 was cancelled.")
            }
        }

        // Wait for 10 seconds before cancelling
        delay(10_000)
        println("Main: Cancelling both coroutines after 10 seconds...")

        // Cancel both jobs
        job1.cancelAndJoin()
        job2.cancelAndJoin()

        println("Main: Both coroutines cancelled.")
    }
}