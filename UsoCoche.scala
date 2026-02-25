object UsoCoche {

    def main(args: Array[String]): Unit = {

        val miCoche = new Coche("Seat Ibiza", 55000, 2025, true)

        println("Mi coche es un " + miCoche.getModelo() + " y vale " + miCoche.precio() + " euros.")

        val cochePepe = new Coche("Seat Ibiza", 55000, 2025, true)

        println("Mi coche tiene id " + miCoche.id + " y el de Pepe " + cochePepe.id + ".")

        println("Mi coche y el de Pepe son " + (if (cochePepe == miCoche) "iguales." else "distintos."))

        println("Mi coche: " + miCoche.hashCode())
        println("Coche de Pepe: " + cochePepe.hashCode())

        
    }

}

object Coche {

    val MAX_COCHES: Int = 100
    private var numCoches: Int = 0

    def getNumCoches(): Int = numCoches

    def registrarNuevoCoche(): Int = {

        if (numCoches == MAX_COCHES) throw new IllegalArgumentException("No se permiten más coches")

        numCoches += 1

        numCoches

    }

}

class Coche(
    private var modelo: String,
    private var numKilometros: Int, 
    private var fechaMatriculacion: Int,  
    private var tieneAire: Boolean) {

    val id = Coche.registrarNuevoCoche()

    def getModelo(): String = modelo

    def setModelo(modelo: String): Unit = this.modelo = modelo 

    def getNumKilometros(): Int = numKilometros
    
    def setNumKilometros(numKilometros: Int): Unit = this.numKilometros = numKilometros
    
    def getFechaMatriculacion(): Int = fechaMatriculacion

    def setFechaMatriculacion(fechaMatriculacion: Int): Unit = {
        if (fechaMatriculacion < 1920 || fechaMatriculacion > 2026) throw new IllegalArgumentException("Fecha no válida")
        this.fechaMatriculacion = fechaMatriculacion
        }
    
    def isTieneAire(): Boolean = tieneAire

    def setTieneAire(tieneAire: Boolean): Unit = this.tieneAire = tieneAire

    //Métodos definidos
     def precio(): Int = {

        var precio = 5000

        precio -= 10*(2026-this.fechaMatriculacion)

        if (this.tieneAire) precio += 1000
        else precio -= 1000

        precio

    }

    def  instalarAire(): Unit = this.tieneAire = true

    override def equals(other: Any): Boolean = other match {

        case that: Coche => this.modelo == that.modelo 
                && this.fechaMatriculacion == that.fechaMatriculacion
                && this.tieneAire == that.tieneAire
        
        case _ => false

    }

    override def hashCode(): Int = (modelo, fechaMatriculacion, tieneAire).##

}

class Furgoneta(
    modelo: String, 
    numKilometros: Int, 
    fechaMatriculacion: Int, 
    tieneAire: Boolean,
    private var capacidadCarga: Int)

    extends Coche(modelo, 
            numKilometros, 
            fechaMatriculacion, 
            tieneAire) {

        def getCapacidadCarga(): Int = capacidadCarga
        def setCapacidadCarga(capacidadCarga: Int): this.capacidadCarga = capacidadCarga

}