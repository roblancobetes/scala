object Frase {

    def main(args: Array[String]): Unit = {

        val listaPalabras = Array("Soy", "Rodrigo", "y", "me", "encanta", "Scala")

        val listaConEspacio = listaPalabras.map(_ + " ")

        val frase = listaConEspacio.reduceLeft(_ + _).dropRight(1) + "."

        println("Declarativa: " + frase)

        println("Imperativa: " + construirFrase(listaPalabras))

    }

    def construirFrase(listaPalabras: Array[String]): String = {

        var frase = ""

        for (i <- 0 until listaPalabras.length) {

            frase += listaPalabras(i) + " "

        }

        frase = frase.dropRight(1) + "."

        frase

    }

}