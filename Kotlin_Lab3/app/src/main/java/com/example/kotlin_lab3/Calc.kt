package com.example.kotlin_lab3

fun main() {
    print("Enter first number: ")
    val num1 = readLine()?.toDoubleOrNull()

    print("Enter operator (+, -, *, /): ")
    val operator = readLine()

    print("Enter second number: ")
    val num2 = readLine()?.toDoubleOrNull()

    if (num1 == null || num2 == null || operator.isNullOrBlank()) {
        println("Invalid input.")
        return
    }

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if (num2 != 0.0) num1 / num2 else "Cannot divide by zero"
        else -> "Unknown operator"
    }

    println("Result: $result")
}
