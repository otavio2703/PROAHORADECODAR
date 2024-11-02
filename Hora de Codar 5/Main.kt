var saldo: Double = 150.00
val senha: Int = 3589

fun main() {
    inicio()
}

fun inicio() {
    println("Qual o seu nome?")
    val usuario = readln()
    println("Seja bem-vindo, $usuario! É um prazer tê-lo conosco.")
    menu(usuario)  // Passa o nome do usuário para o menu
}

fun menu(usuario: String) {
    println("Escolha uma opção:")
    println("Ver Saldo -> 1")
    println("Extrato -> 2")
    println("Saque -> 3")
    println("Depósito -> 4")
    println("Transferência -> 5")
    println("Voltar ao início -> 6")
    println("Sair -> 7")
    val opcao = readln().toInt()
    when (opcao) {
        1 -> versaldo(usuario)
        2 -> extrato(usuario)
        3 -> saque(usuario)
        4 -> deposito(usuario)
        5 -> transferencia(usuario)
        6 -> menu(usuario) // Volta ao menu principal com o mesmo usuário
        7 -> sair(usuario) // Opção de saída com agradecimento
        else -> erro(usuario)
    }
}

fun sair(usuario: String) {
    println("$usuario, foi um prazer ter você por aqui!")
}

fun saque(usuario: String) {
    println("Por favor, insira sua senha:")
    val senhaUsuario = readln().toInt()

    if (senhaUsuario != senha) {
        println("Senha incorreta! Tente novamente.")
        saque(usuario)
        return
    }

    println("Insira o valor de saque:")
    val saque = readln().toInt()

    if (saque <= 0) {
        println("O valor inserido é inválido")
        saque(usuario)
    } else {
        val subtracao = saldo - saque
        if (subtracao < 0) {
            println("Operação inválida")
            saque(usuario)
        } else {
            saldo = subtracao
            println("O seu valor atual é R$$saldo")
        }
    }
    menu(usuario)
}

fun versaldo(usuario: String) {
    println("Por favor, insira sua senha:")
    val senhaUsuario = readln().toInt()
    if (senhaUsuario != senha) {
        println("Senha incorreta! Tente novamente.")
        versaldo(usuario)
        return
    }
    println("O seu saldo atual é R$$saldo")
    menu(usuario)
}

fun extrato(usuario: String) {
    println("Por favor, insira sua senha:")
    val senhaUsuario = readln().toInt()
    if (senhaUsuario != senha) {
        println("Senha incorreta! Tente novamente.")
        extrato(usuario)
        return
    }
    val compras = mutableListOf("Coca Cola", "Miojo", "Bolacha")
    val depositos = mutableListOf("Ted", "Transferência", "Depósito em conta", "Pix")
    println("Compras:")
    for (compra in compras) {
        println(compra)
    }
    println("Depósitos:")
    for (deposito in depositos) {
        println(deposito)
    }
    menu(usuario)
}

fun transferencia(usuario: String) {
    println("Informe o número da conta!")
    val numeroConta = readln().toInt()
    println("Qual valor deseja transferir?")
    val envio = readln().toDouble()

    if (envio <= 0) {
        println("O valor inserido é inválido")
        saque(usuario)
    } else if (envio > saldo) {
        println("Operação inválida: saldo insuficiente")
        saque(usuario)
    } else {
        saldo -= envio
        println("Você enviou R$$envio para a conta $numeroConta e agora tem R$$saldo")
    }
    menu(usuario)
}

fun erro(usuario: String) {
    println("O número digitado não corresponde a nenhuma operação. Tente novamente!")
    menu(usuario)
}

fun deposito(usuario: String) {
    println("Por favor, insira sua senha:")
    val senhaUsuario = readln().toInt()

    if (senhaUsuario != senha) {
        println("Senha incorreta! Tente novamente.")
        deposito(usuario)
        return
    }

    println("Qual valor deseja depositar?")
    val valorUser = readln().toDouble()

    if (valorUser <= 0) {
        println("O valor inserido é inválido")
        saque(usuario)
    } else {
        saldo += valorUser
        println("Você depositou R$$valorUser e agora tem R$$saldo")
    }

    menu(usuario)
}
