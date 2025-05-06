package com.example.scopefunctions

data class Person(var name: String, var id: Int, var gender: String)
fun main() {
    // Using let
     Person("Mariam", 1, "Female").let {
        println("${it.name}, ${it.id}, ${it.gender}")
        it.name = "Fatma"
        println(it)
    }
    // Using run
    Person("", 2, "Male").run {
        println(" $name, $id, $gender")
        name = "Mohamed"
        println(this)
    }

    // Using also
    val person3 = Person("", 3, "Male").also {
        println("${it.name}, ${it.id}, ${it.gender}")
        it.name = "Ahmed"
        println(it)
    }


}
