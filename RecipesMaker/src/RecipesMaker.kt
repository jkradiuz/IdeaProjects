fun main(args: Array<String>) {
    val lstIngredientes: List<String> =
        listOf<String>("Agua", "Leche", "Carne", "Verduras", "Frutas", "Cereal", "Huevos", "Aceite")
    val Receta = mutableListOf<String?>()

    do {

        val txtBienvenida = """
        :: Bienvenido a Recipe Maker ::
        
        Selecciona la opción deseada
        1. Hacer una receta
        2. Ver mis recetas
        3. Salir
    """.trimIndent()
        mostrarbienvenida@ println(txtBienvenida)

        val op: String? = readLine()

        when (op) {
            "1" -> {
                var sReceta: String? = null
                do {
                    println("Ingredientes Disponibles")
                    for (i in 0..7) {
                        println("${i.plus(1)}. " + lstIngredientes[i])
                    }
                    println("9. Terminar Receta")
                    println("Seleccione un Ingrediente")
                    val opr: String? = readLine()
                    if (opr != "9"&&opr != "0") {
                        if (sReceta?.length ?: 0 == 0) sReceta = opr
                        else sReceta = "$sReceta,$opr"
                    }

                } while (opr != "9")
                Receta.add(sReceta)
                println(Receta)
            }
            "2" -> {
                for ((index, r) in Receta.withIndex()) {
                    var lstI = r?.split(",")?.toList()
                    var sReceta: String? = null
                    lstI?.forEach {
                        if (sReceta?.length ?: 0 == 0) sReceta = lstIngredientes[it.toInt() - 1]
                        else sReceta = "$sReceta," + lstIngredientes[it.toInt() - 1]
                    }
                    println("Receta No. ${index.plus(1)} =\"$sReceta\" ")
                }
            }
            "3"-> println("Vuelva Pronto")
            else -> println("Seleccione una opción valida")
        }
    } while (op != "3")


}