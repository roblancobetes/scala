import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.{Map => MutableMap}

object MapaInverso {

    def main(args: Array[String]): Unit = {

        val edades = Map("Ana"-> 25, "Jose" -> 30, "Julio" -> 25)

        //Utilizo el mapa imperativo con clave: String y valor: Int
        val inverso = crearInverso(edades)

        //Utilizo el mapa con tipos genéricos
        val inversoGenerico = crearInversoGenerico(edades)

        println("{")
        inverso.foreach{ case (clave, valor) => println(s"$clave -> $valor")}
        println("}")

        println("Genérico: {")
        inversoGenerico.foreach{ case (clave, valor) => println(s"$clave -> $valor")}
        println("}")
      

        //Forma declarativa
        val inverso1 = edades.map{ case(clave, valor) => (valor, clave) } //Ignoro repetidos

        println("{")
        inverso1.foreach{ case (clave, valor) => println(s"$clave -> $valor")}
        println("}")

    val inverso2 = edades
    .groupBy{case (nombre, edad) => edad}
    .view //Crear una evaluación perezosa
    .mapValues(_.keys.toList)
    .toMap //Deshacer la evaluación perezosa

    // val inverso2 = edades.groupBy(_._2).mapValues(_.keys.toList) (alternativa más directa sin evaluación perezosa)

    println("{")
        inverso2.foreach{ case (clave, valor) => println(s"$clave -> $valor")}
        println("}")

    }


    def crearInverso(mapa: Map[String, Int]): MutableMap[Int, ArrayBuffer[String]] = {

        var inverso = MutableMap[Int, ArrayBuffer[String]]()

        for ((nombre, edad) <- mapa) {

            if (inverso.contains(edad)) inverso(edad).addOne(nombre)
            else inverso += (edad, ArrayBuffer(nombre))

        }

        inverso

    }

    //Función sin especificar el tipo de la clave K y el valor V
    def crearInversoGenerico[K, V](mapa: Map[K, V]): MutableMap[V, ArrayBuffer[K]] = {

        var inverso = MutableMap[V, ArrayBuffer[K]]()

        for ((clave, valor) <- mapa) {

            if (inverso.contains(valor)) inverso(valor).addOne(clave)
            else inverso += (valor, ArrayBuffer(clave))

        }

        inverso

    }



}