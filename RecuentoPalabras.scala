import scala.collection.mutable.{Map => MutableMap}


object RecuentoPalabras {

    def main(args: Array[String]): Unit = {

        val poema = """En la penumbra azul de la mañana, 
                    cuando el rocío tiembla en la alborada, 
                    despierta el mundo, luz recién sembrada, 
                    como un latido fiel tras la ventana. 

                    Suspira el viento leve en la campana 
                    del viejo campanario en la enramada, 
                    y el tiempo fluye, sombra ya dorada, 
                    sobre la piel callada de la arcana. 

                    Mas yo persigo un sueño entre la bruma, 
                    un nombre escrito en agua y en memoria, 
                    ardiente como sol que no se esfuma. 

                    Y en su fulgor cifrado va mi historia: 
                    si el alba hiere, el corazón perfuma 
                    la breve eternidad de nuestra gloria."""

        val conteo = conteoPalabras(poema)

        conteo.foreach { case(palabra, veces) => println(s"La palabra $palabra aparece $veces veces.")}

        //Forma declarativa:
        val conteo2 = poema
                .split("[\\s.,]+")
                .view //Genera una evaluación "perezosa" (lazy)
                .map(_.toLowerCase)
                .groupBy(identity)
                .view //groupBy se "carga" la evaluación perezosa
                .map({ case (palabra, lista) => (palabra, lista.size)})
                .toMap //Deshace la vista perezosa
                

        conteo2.foreach { case(palabra, veces) => println(s"D: La palabra $palabra aparece $veces veces.")}

    }

    def conteoPalabras(texto: String): MutableMap[String, Int] = {

        val listaPalabras = texto.split("[\\s.,]+")

        var conteo = MutableMap[String, Int]()

        for (palabra <- listaPalabras) {

            val palabraMinuscula = palabra.toLowerCase

            if (conteo.contains(palabraMinuscula)) conteo(palabraMinuscula) += 1
            else conteo += (palabraMinuscula -> 1)

        }

        conteo

    }


}