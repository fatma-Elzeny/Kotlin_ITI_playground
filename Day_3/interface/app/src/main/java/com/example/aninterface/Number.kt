package com.example.aninterface

import android.annotation.SuppressLint

interface NumberSeries {

    var Start : Int
    var current :Int
    fun reset()
    fun getNext ():Int


}

class ByThrees : NumberSeries{
    override var current: Int = 0

    override var Start: Int=0
        set(value) {
            field=value
            current=value
        }
    override fun reset() {
       current= Start
    }

    override fun getNext(): Int {
        current+=3
        return current
    }

}


fun main(){
 val byThrees = ByThrees()
 var ref : NumberSeries
 repeat(5){
    ref = byThrees
    println("By Three : ${ref.getNext()}")
   }





}