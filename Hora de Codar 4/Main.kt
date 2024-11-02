fun main(){
    menu()
}

fun menu() {
    println("Escolha uma opção:")
    println("Atividade 1 -> 1")
    println("Atividade 2 -> 2")
    println("Atividade 3 -> 3")
    val opcao = readln().toInt()
    when (opcao) {
        1 -> atividade1()
        2 -> atividade2()
        else -> atividade3()
    }
}

    fun atividade1() {
    val estudantes = mutableListOf<String>()
    println("Bem-vindo ao sistema de cadastro de estudantes!")

    while (true) {
        println("Digite o nome do estudante para cadastrar ou 'PARE' para finalizar:")
        val nomeEstudante = readln()

        if (nomeEstudante.uppercase() == "PARE") {
            println("Cadastro finalizado.")
            println("Total de estudantes cadastrados: ${estudantes.size}")
            println("Lista de estudantes cadastrados:")
            for (estudante in estudantes) {
                println("- $estudante")
            }
            println("Obrigado por usar o sistema de cadastro de estudantes!")
            break
        } else {
            estudantes.add(nomeEstudante)
            println("Estudante '$nomeEstudante' cadastrado com sucesso!")
        }
    }
}
        fun atividade2() {
            val planetas = arrayOf("Terra", "Marte", "Plutão", "Vênus", "Júpiter", "Saturno")

            println("Digite o nome de um planeta:")
            val planetaUsuario = readln()

             if (planetas.contains(planetaUsuario)) {
            println("O planeta $planetaUsuario está na lista!")
             } else {
             println("O planeta $planetaUsuario não está na lista.")
    }
}

        fun atividade3() {
         var frutas = mutableListOf("Maçã", "Banana", "Laranja", "Pera", "Uva")

         println("Lista de frutas disponíveis: $frutas")

            while (frutas.isNotEmpty()) {
                println("Digite o nome de uma fruta para remover da lista:")
                val frutaUsuario = readln()

                 if (frutas.contains(frutaUsuario)) {
                 frutas.remove(frutaUsuario)
                 println("Fruta '$frutaUsuario' foi retirada da lista.")
                 } else {
                 println("Fruta indisponível no nosso mercado.")
        }

                 if (frutas.isEmpty()) {
                 println("Lista de compras finalizada.")
        }           else {
            println("Frutas restantes na lista: $frutas")
        }
    }
}
