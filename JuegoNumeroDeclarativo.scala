import scala.util.Random

object JuegoNumeroDeclarativo {

    def main(args: Array[String]): Unit = {

        val numeroSecreto = Random.between(0, 101)
        jugar(numeroSecreto, 1)

    }

    def jugar(numeroSecreto: Int, contador: Int): Unit = {

    println("Introduce un número:")

    val intento = scala.io.StdIn.readInt()

    //Supongamos que acierta
    if (intento == numeroSecreto) println("Acertaste el número " + numeroSecreto + " tras " + contador + " intentos.")

    //Supongamos que no acierta
    else {

        if (intento > numeroSecreto) println("El número que se busca es menor")
        else println("El número que se busca es mayor")
        jugar(numeroSecreto, contador + 1)

    }

    }

}