import scala.util.Random.{nextInt, nextBoolean}

object CocheCaseClass {

    def main(args: Array[String]): Unit = {

        val miCoche = Coche("Seat Ibiza", 2026, 50000, true) //Coche.apply("Seat Ibiza, 2026 ...")

        val cochePepe = Coche("Seat Ibiza", 2026, 50000, true)

        println(miCoche)

        println("Mi coche y el de Pepe son " + (if (cochePepe == miCoche) "iguales." else "distintos."))

        println("Mi coche: " + miCoche.hashCode())
        println("Coche de Pepe: " + cochePepe.hashCode())

        val modelos = List("Seat Ibiza", "Toyota", "Ford Focus", 
            "Mercedes", "Audi A7")

        val coches: List[Coche] = List.fill(100) {

            Coche(modelo = modelos(nextInt(modelos.length)),
            fechaMatriculacion = 1920 + nextInt(106),
            numKilometros = nextInt(200000),
            tieneAire = nextBoolean())
        }

        val cuantosTienenAire = coches.count(_.tieneAire)

        val conteoModelos = coches
        .groupBy{case Coche(modelo, fechaMatriculacion, numKilometros, tieneAire) => modelo} 
        //Por detrás case Coche(...) => llama a Coche.unapply(...)
        .mapValues(_.length)

        val precioPorModelo = coches
        .groupBy(_.modelo) //Diccionario que asocia cada modelo a la lista de coches con ese modelo
        .mapValues(_.map(_.precio())) //Cada modelo asociado a la lista de precios de coches con ese modelo
        .mapValues(lista => lista.sum.toDouble/lista.size) //Mapa con el precio medio de cada modelo


        println("{")
        precioPorModelo.foreach{ case (clave, valor) => println(s"$clave -> $valor")}
        println("}")

        println(coches.take(5))

        println("Tienen aire los siguientes coches: " + cuantosTienenAire)

        println("Mi total de coches es " + Coche.getNumCoches() + ".")

    }

}

object Coche {

    val MAX_COCHES = 200
    private var numCoches = 0

    def getNumCoches(): Int = numCoches

    def apply(modelo: String, 
        fechaMatriculacion: Int, 
        numKilometros: Int, tieneAire:
        Boolean): Coche = {

        if (numCoches == MAX_COCHES) throw new IllegalArgumentException("No se permiten más coches")

        Coche.numCoches += 1
        new Coche(modelo,fechaMatriculacion, numKilometros, tieneAire)

        }

}

case class Coche(modelo: String,
 fechaMatriculacion: Int,
 numKilometros: Int,
 tieneAire: Boolean) //Crea atributos inmutables por defecto
{
    require(fechaMatriculacion >= 1920 && fechaMatriculacion <= 2026, "Fecha no válida")

    def precio(hoy: Int = 2026 ): Int = {

        val base = 5000

        val depreciacion = 10 * (hoy - fechaMatriculacion)

        val ajusteAire = if (tieneAire) 1000 else -1000

        base - depreciacion + ajusteAire
        
    }
    
}
