package com.example.kotlin_lab6
abstract class Shape(){
    protected var dim1: Float = 0f
   constructor(d1: Float) : this() {
        dim1 = d1
    }

    public abstract fun calcArea():Float
}

class Rectangular(d1: Float,var height:Float) : Shape(d1) {
    override fun calcArea(): Float {
        return dim1*height
    }

}


class Triangle(d1: Float,var height: Float) : Shape(d1) {

    override fun calcArea(): Float {
        return 0.5f*dim1*height
    }

}
class Circle(d1: Float) : Shape(d1) {

    override fun calcArea(): Float {
          return (22f/7)*dim1*dim1
    }

}

class Picture () {

    fun Calcualtion (){
         var R = Rectangular(5f,4f)
         println("The Area of the Rectangular "+R.calcArea())
         var T = Triangle(5f,4f)
        println("The Area of the Triangle "+T.calcArea())
        var C = Circle(5f)
        println("The Area of the Circle "+C.calcArea())
        var picture = Picture()
          println("The Sum of Areas "+picture.sumAreas(R,T,C))

    }
    fun sumAreas(g1:Shape ,g2:Shape,g3:Shape) : Float {

        return g1.calcArea() + g2.calcArea() + g3.calcArea();
    }
}
fun main () {
    var picture = Picture()
    picture.Calcualtion()
}
