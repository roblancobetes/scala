import scala.util.Random

object JuegoNumero {

    def main(args: Array[String]): Unit = {

    val numeroSecreto = Random.between(0, 101)

    println("Introduce un número:")

    var intento = scala.io.StdIn.readInt()

    var numIntentos = 0

    while (intento != numeroSecreto) {

        numIntentos += 1

        if (numeroSecreto > intento) println("El número es mayor")

        else println("El número es menor")

        println("Introduce otro número:")

        intento = scala.io.StdIn.readInt()

    }

    println("Acertaste el número que era " + numeroSecreto + " tras " + numIntentos + " intentos")

    }

    //Ejemplo básico de función recursiva
    def factorial(n: Int): Int = {

        if (n<=1) 1

        else n * factorial(n-1)        

    }

    def loop(intento: Int): Unit = {



    }

}