object Producto {

    def main(args: Array[String]): Unit = {

        val A : Array[Array[Int]] = Array(Array(2, 2, 3), Array(-1, 2, 5))

        val B : Array[Array[Int]] = Array(Array(-1, 2), Array(1, 5), Array(0, -5))

        val C = multiplicarMatrices(A,B)

        C.foreach{ fila => println(fila.mkString("[", ",", "]"))}

    }

    def multiplicarMatrices(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {

        require(A(0).length==B.length, "Matrices no multiplicables")

        val n = A.length

        val m = B(0).length

        val l = B.length

        val C = Array.ofDim[Int](n, m)

        for (i <- 0 until n) {

            for (j <- 0 until m) {

                for (k <- 0 until l) C(i)(j) += A(i)(k)*B(k)(j)

            }

        }

        C

    }

}