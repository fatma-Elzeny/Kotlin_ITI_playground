package com.example.job

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Main: Starting...")

        // Create a Job using launch
        val job = launch {
            try {
                repeat(5) { i ->
                    println("Job: Working on task $i")
                    delay(1000)
                }
                println("Job: Finished successfully")
            } catch (e: CancellationException) {
                println("Job: Cancelled!")
            }
        }

        // Wait for the job to finish using join()
        println("Main: Waiting for job to finish with join()")
        job.join()
        println("Main: Job completed using join()\n")

        // Relaunch job to demonstrate cancelAndJoin
        val cancelJob = launch {
            try {
                repeat(10) { i ->
                    println("CancelJob: Running task $i")
                    delay(1000)
                }
            } catch (e: CancellationException) {
                println("CancelJob: Caught cancellation exception.")
            }
        }

        delay(3000) // Let it run for a few seconds
        println("Main: Cancelling job with cancelAndJoin()")
        cancelJob.cancelAndJoin() // Cancel and wait for it to finish
        println("Main: cancelAndJoin complete")
    }
}
