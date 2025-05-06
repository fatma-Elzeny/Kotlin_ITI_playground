package com.example.classes

enum class Building {
    VILLA,
    APARTMENT
}
class Person (val name: String, val address: Address){
    data class Address(
        val streetName: String,
        val city: String,
        val building: Building

    )

   override fun toString(): String {

        return "Name :$name,Address:[$address]"
    }
}


fun main (){
    val address = Person.Address(
        streetName = "Ibn-Khaldon",
        city = "Zagazig",
        building = Building.VILLA
    )

    val person = Person ( name = "Fatma",address)
    println(person)
}