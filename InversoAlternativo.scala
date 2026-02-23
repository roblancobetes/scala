import scala.collection.mutable.ArrayBuffer

object InversoAlternativo {

    def main(args: Array[String]): Unit = {

        val edades = Map("Ana"-> 25, "Jose" -> 30, "Julio" -> 25)

        println("Introduce la edad que quieres consultar:")

        var edadBuscada = scala.io.StdIn.readInt()

        var personas = ArrayBuffer[String]()

        for ((persona, edad) <- edades) {

            if (edad == edadBuscada) personas.addOne(persona)

        }

        //Alternativa declarativa
        val personasDeclarativa = edades.filter{ (persona, edad) => (edad == edadBuscada)}.keys.toList

        if (personas.length == 0) println("No hay nadie que coincida con el criterio de búsqueda")

        else {

            print("Las personas con " + edadBuscada + " años son")

            personas.foreach(persona => print(", " + persona ))

            println(".")

            //Equivalente declarativo

            print("D: Las personas con " + edadBuscada + " años son")

            personasDeclarativa.foreach(persona => print(", " + persona ))

            println(".")

        }

    }



}