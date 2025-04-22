package com.example.kotlin_lab5
fun main() {
    print("Enter your first name: ")
    val firstName = readLine()

    print("Enter your last name: ")
    val lastName = readLine()

    if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank()) {
        println("Full name: $firstName $lastName")
    } else {
        println("Please enter both first and last names.")
    }
}

