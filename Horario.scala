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

    val listaTurnos = tablaHorario.drop(1).flatMap(_.drop(1))

    val (libresAcc, descansoDeclarativo): (Int, Boolean) = listaTurnos.foldLeft((2, true)){ 
        case ((libresAcc, valido), hueco) => 
            if (hueco == "turno" && libresAcc < 2) (0, false)
            else if (hueco == "turno" && libresAcc >= 2) (0, valido)
            else (libresAcc + 1, valido)
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