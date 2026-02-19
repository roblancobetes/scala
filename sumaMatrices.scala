object Matrices {

    def main(args: Array[String]): Unit = {

        val A : Array[Array[Int]] = Array(Array(2, 2, 3), Array(-1, 2, 5))

        val B : Array[Array[Int]] = Array(Array(-1, 2, 0), Array(1, 5, -4))

        val C = sumarMatrices(A,B)

        C.foreach{ fila => println(fila.mkString("[", ",", "]"))}

        val filasEnParejas = A.zip(B)
        
        val sumaDeclarativa = filasEnParejas.map{ case (fa, fb) => fa.zip(fb).map{case (a, b) => a + b} }

        sumaDeclarativa.foreach{ fila => println(fila.mkString("[", ",", "]"))}

    }

    def sumarMatrices(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {

        require(A.length == B.length && A(0).length == B(0).length, "Las matrices deben tener las mismas dimensiones")

        val n = A.length

        val m = A(0).length

        val C = Array.ofDim[Int](n, m)

        for (i <- 0 until n) {

            for (j <- 0 until m) C(i)(j) = A(i)(j) + B(i)(j)

        }

        C

    }

}