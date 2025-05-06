package com.example.functions


class Complex(val real: Float = 0f, val imaginary: Float = 0f) {

    constructor(real : Float) :this (real,0f)

    constructor(real: Int, imaginary: Int) : this(real.toFloat(), imaginary.toFloat())

    // Operator overloading for +
    operator fun plus(complex: Complex): Complex {
        return Complex(
            real = this.real + complex.real,
            imaginary = this.imaginary + complex.imaginary
        )
    }

    // Operator overloading for -
    operator fun minus(complex: Complex): Complex {
        return Complex(
            real = this.real - complex.real,
            imaginary = this.imaginary - complex.imaginary
        )
    }
    override fun toString(): String {
        return if (imaginary >= 0)
            "$real + ${imaginary}i"
        else
            "$real - ${-imaginary}i"
    }
}

// Extension function to print complex numbers
fun Complex.print(prefix: String = "Complex number is:") {
    println("$prefix $this")
}

// --- Usage Example ---
fun main() {
    val c1 = Complex(real = 3f, imaginary = 4f)
    val c2 = Complex(1, -2)

    val sum = c1 + c2

    print(sum)
}