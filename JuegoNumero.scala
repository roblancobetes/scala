import scala.util.Random

object JuegoNumero {

    def main(args: Array[String]): Unit = {

    val numeroSecreto = Random.between(0, 101)

    println("Introduce un número:")

    val intento = scala.io.StdIn.readInt()

    if (intento == numeroSecreto) println("Acertaste el número " + intento)

    else println("Fallo, era: " + numeroSecreto)

    println(factorial(6))

    }

    //Ejemplo básico de función recursiva
    def factorial(n: Int): Int = {

        if (n<=1) 1

        else n * factorial(n-1)        

    }

    def loop(intento: Int): Unit = {

        

    }

}