object Horario {

    def main(args: Array[String]): Unit = {

    val tablaHorario: Array[Array[String]] = Array(
    Array("Horario", "Mañana", "Tarde", "Noche"),
    Array("Lunes", "turno", "libre", "libre"),
    Array("Martes", "turno", "libre", "libre"),
    Array("Miércoles", "libre", "turno", "libre"),
    Array("Jueves", "libre", "libre", "turno"),
    Array("Viernes", "libre", "libre", "turno"))

    println("El rendimiento es " + calcularRendimiento(tablaHorario))

    println("El descanso es " + (if (chequearDescansos(tablaHorario)) "correcto." else "incorrecto"))

    //Rendimiento de forma declarativa
    val totalJornadas: Double = tablaHorario
    .drop(1)
    .flatMap(_.drop(1))
    .count( palabra => true )

    val totalTurnos: Double = tablaHorario
    .drop(1)
    .flatMap(_.drop(1))
    .count( _.toLowerCase == "turno")

    println("Declarativamente sale: " + totalTurnos/totalJornadas)

    val (descansoDeclarativo, libresAcum) = tablaHorario.flatten.foldLeft((true, 2)){
        case ((false, libres), _) => (false, libres)
        case ((true, libres), "libre") => (true, libres + 1)
        case ((true, libres), "turno") => 
            if (libres < 2) (false, 25) else (true, 0)
        case ((accValido, accLibres), _) => (accValido, accLibres)
    }

    println("Declarativamente: el descanso es " + (if (descansoDeclarativo) "correcto." else "incorrecto"))


    }

    def calcularRendimiento(tablaHorario: Array[Array[String]]): Double = {

        var totalTurnos: Double = 0

        var totalDias: Double = 0

        for (i <- 1 until tablaHorario.length) {

            for (j <- 1 until tablaHorario(i).length) {

                if ( tablaHorario(i)(j).toLowerCase == "turno" ) totalTurnos += 1

                totalDias += 1
            }

        }

        totalTurnos/totalDias

    }

    def chequearDescansos(tablaHorario: Array[Array[String]]): Boolean = {

        var libresAcc = 2

        var valido = true

        for (i <- 1 until tablaHorario.length) {

            for (j <- 1 until tablaHorario(i).length) {

                if (tablaHorario(i)(j).toLowerCase == "turno") {

                    if (libresAcc < 2) valido = false

                    else libresAcc = 0

                }

                else libresAcc += 1

            }

        }

        valido

    }




}