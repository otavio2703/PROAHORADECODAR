var nomeUsuario: String = ""
fun main() {
    val senhaCorreta = 2678

    println("Bem vindo ao Grand Hotel Budapeste")
    println("----------------------------------")
    println("Por favor, digite o nome de usuário: ")
    nomeUsuario = readln()


    println("Agora, digite sua senha: ")
    val senha = readln().toInt()

    if(senha == senhaCorreta){
        println("Bem vindo ao Grand Hotel Budapeste, $nomeUsuario. É um imenso prazer ter você por aqui!")
        println("---------------------------------------------------------------------------------------")

        println("Selecione uma opção:")
        println("1.) Reserva de Quartos")
        println("2.) Cadastro de Hóspedes")
        println("3.) Pesquisa de Hóspedes")
        println("4.) Agendamento de Eventos")
        println("5.) Abastecimento de Carros")
        println("6.) Manutenção de Ar-Condicionados")
        println("7.) Sair")
        println("---------------------------------------------------------------------------------------")

        val escolha = readln().toIntOrNull()

        when (escolha) {
            1 -> reservaQuartos()
            2 -> cadastroHospedes()
            3 -> pesquisarHospedes()
            4 -> eventoHotel()
            5 -> abastecerCarros()
            6 -> manutencaoAr()
            7 -> sair()
            else -> erro()
        }

    }else{
        println("Senha inválida!")
        main()
    }



}
//--------------------------------------------------------------------------------------------------
fun reservaQuartos() {
    println("GRAND HOTEL BUDAPESTE - RESERVA DE QUARTOS")
    println("------------------------------------------")

    println("Qual o valor padrão da diária: ")
    val valorDiaria = readln().toDouble()

    if (valorDiaria > 0) {
        println("Quantas diárias serão necessárias? ")
        val numeroDiarias = readln().toInt()

        if (numeroDiarias > 0) {
            val total = valorDiaria * numeroDiarias
            println("O valor de $numeroDiarias dias de hospedagem é de R$ $total")

            println("Qual o nome do hospede?")
            val nomeHospede: String = readln()

            println("Qual quarto gostaria de reservar? (1-20)?")
            val numeroQuarto = readln().toInt()

            if (numeroQuarto > 0 && numeroQuarto < 20) {
                println("Quarto livre!")
                println("$nomeUsuario, você confirma a hospedagem para $nomeHospede por $numeroDiarias dias para o quarto $numeroQuarto por R$ $valorDiaria? S/N")
                val escolha = readln().uppercase()

                when (escolha) {
                    "S" -> {
                        println("$nomeUsuario, reserva efetuada para $nomeHospede.")
                        println("Lista de quartos e suas ocupações: Quarto $numeroQuarto ocupado.")
                    }
                    "N" -> main()
                    else -> {
                        println("Desculpe, mas não entendi.")
                        reservaQuartos()
                    }
                }
            } else {
                println("Valor inválido!")
                reservaQuartos()
            }

        } else {
            println("Valor inválido!")
            reservaQuartos()
        }

    }
    println("---------------------------------------------------------------------------------------")
    main()
}
//--------------------------------------------------------------------------------------------------
fun cadastroHospedes() {
    var gratuidade = 0
    var meia = 0
    var totalValor = 0.0

    println("GRAND HOTEL BUDAPESTE - CADASTRO DE HÓSPEDES")
    println("--------------------------------------------")

    println("Qual o valor padrão da diária? ")
    val valorDiaria = readln().toDouble()

    while (true) {
        print("Qual o nome do hóspede? ")
        val nomeHospede = readln()

        if (nomeHospede.uppercase() == "PARE") {
            break
        }

        println("Qual a idade do hóspede? ")
        val idadeHospede = readln().toInt()

        when {
            idadeHospede < 6 -> {
                gratuidade += 1
                println("$nomeHospede possui gratuidade")
            }
            idadeHospede > 60 -> {
                meia += 1
                totalValor += valorDiaria / 2
                println("$nomeHospede paga meia")
            }
            else -> {
                totalValor += valorDiaria
                println("$nomeHospede cadastrada(o) com sucesso.")
            }
        }
    }

    println("Quantidade de gratuidades: $gratuidade")
    println("Quantidade de meias hospedagens: $meia")
    println("Valor total das hospedagens: R$ $totalValor")
    println("---------------------------------------------------------------------------------------")
    main()
}
// ___________________________________________________________________________________________________
val listaHospedes = mutableListOf<String>()
fun pesquisarHospedes() {
    println("Bem-vindo à aba de pesquisas do Grand Hotel Budapeste!")
    println("---------------------------------------------------------------------------------------")

    println("Selecione uma opção:")
    println("1.) Cadastrar")
    println("2.) Pesquisar")
    println("3.) Sair")

    val escolha = readln().toIntOrNull()

    when (escolha) {
        1 -> cadastrar()
        2 -> pesquisar()
        3 -> main()
        else -> {
            println("Opção inválida. Tente novamente.")
            println("---------------------------------------------------------------------------------------")
            pesquisarHospedes()
        }
    }
}

fun cadastrar() {
    println("Você escolheu cadastrar.")
    println("Qual o nome do hóspede?")
    val nomeHospede = readln()


    listaHospedes.add(nomeHospede)
    println("Hóspede $nomeHospede foi cadastrado com sucesso!")
    pesquisarHospedes()
    println("---------------------------------------------------------------------------------------")
}

fun pesquisar() {
    println("Você escolheu pesquisar.")
    println("Qual o nome do hóspede?")
    val nomeHospede = readln()


    if (listaHospedes.contains(nomeHospede)) {
        println("Hóspede $nomeHospede foi encontrado(a)!")
    } else {
        println("Este hóspede não está na lista.")
    }
    println("---------------------------------------------------------------------------------------")
    pesquisarHospedes()
}
// _____________________________________________________________________________
fun eventoHotel() {
    println("GRAND HOTEL BUDAPESTE - EVENTOS")
    println("---------------------------------------------------------------------------------------")

    println("Qual é o número de convidados para o seu evento?")
    val nConvidados = readln().toInt()

    val nCadeiras = 220 - nConvidados

    val buffetEvento = {
        val cafe = 0.2
        val agua = 0.5
        val salgados = 7

        val valorCafe = 0.80
        val valorAgua = 0.40
        val valorSalgado = 34

        val totalCafe = cafe * nConvidados
        val totalAgua = agua * nConvidados
        val totalSalgados = salgados * nConvidados

        val valorCafeTotal = totalCafe * valorCafe
        val valorAguaTotal = totalAgua * valorAgua
        val valorSalgadoTotal = totalSalgados * valorSalgado

        val totalValorTotal = valorCafeTotal + valorAguaTotal + valorSalgadoTotal

        println("O evento precisará de $totalCafe litros de café, $totalAgua litros de água, $totalSalgados salgados.")
        println("São R$ $valorCafeTotal de café, R$ $valorAguaTotal de água e R$ $valorSalgadoTotal de salgados. O total de tudo é: R$ $totalValorTotal")
        println("---------------------------------------------------------------------------------------")

        totalValorTotal
    }

    val eventoTrabalho = {
        val custoPorHora = 10.5

        println("Qual a duração do evento em horas?")
        val duracaoEvento = readln().toInt()

        val garconsNecessarios = (nConvidados + 11) / 12
        val garconsExtras = duracaoEvento / 2

        val totalGarcons = garconsNecessarios + garconsExtras
        val custoTotal = totalGarcons * custoPorHora * duracaoEvento

        println("Total de garçons necessários: $totalGarcons")
        println("Custo total com garçons: R$ $custoTotal")

        custoTotal
    }

    val agendarEvento = {
        println("Agora vamos agendar o evento!")
        println("Qual o dia do evento? ")
        val diaEvento = readln()

        println("Qual o horário do evento? ")
        val horaEvento = readln().toInt()

        println("Qual o nome da empresa?")
        val nomeEmpresa = readln()

        println("Auditório reservado para $nomeEmpresa no $diaEvento às $horaEvento hs.")
        val custoBuffet = buffetEvento()
        val custoGarcons = eventoTrabalho()
        val valorTotal = custoBuffet + custoGarcons

        println("Relatório de Custos do Evento:")
        println("Nome da Empresa: $nomeEmpresa")
        println("Data: $diaEvento, $horaEvento hs")
        println("Quantidade de convidados: $nConvidados")
        println("Custo dos garçons: R$ $custoGarcons")
        println("Custo do buffet: R$ $custoBuffet")
        println("Valor total do evento: R$ $valorTotal")

        println("Gostaria de efetuar a reserva? S/N?")
        val escolha = readln().uppercase()

        when (escolha) {
            "S" -> println("${nomeUsuario},reserva efetuada com sucesso.")
            "N" -> {
                println("Reserva não efetuada")
                eventoHotel()
            }
            else -> {
                println("Desculpe, mas não compreendi.")
                println("---------------------------------------------------------------------------------------")
                eventoHotel()
            }
        }
    }

    if (nConvidados > 350) {
        println("Quantidade de convidados superior à capacidade máxima")
        eventoHotel()

    } else if (nConvidados <= 0) {
        println("Número de convidados inválido")
        eventoHotel()

    } else {
        if (nConvidados > 220) {
            println("Use o Auditório Colorado")
            agendarEvento()
        } else {
            println("Use o auditório Laranja (inclua mais $nCadeiras cadeiras)")
            agendarEvento()
        }
    }
}
//--------------------------------------------------------------------------------------------------
fun abastecerCarros() {
    println("GRAND HOTEL BUDAPESTE - ABASTECER")
    println("---------------------------------------------------------------------------------------")

    //val tanque = 42

    println("Qual o valor do álcool no posto Wayne Oil?")
    val wayneAcool = readln().toDouble()

    println("Qual o valor da gasolina no posto Wayne Oil?")
    val wayneGaso = readln().toDouble()

    println("Qual o valor do álcool no posto Stark Petrol?")
    val starkAcool= readln().toDouble()

    println("Qual o valor da gasolina no posto Stark Petrol?")
    val starkGaso = readln().toDouble()

    val wayneDivi = wayneAcool / wayneGaso
    val starkDivi = starkAcool / starkGaso

    if (wayneDivi <= 0.7 && starkDivi <= 0.7) {

        if (wayneAcool < starkAcool) {
            println("$nomeUsuario, é mais barato abastecer com álcool no posto Wayne Oil")
        } else {
            println("$nomeUsuario, é mais barato abastecer com álcool no posto Stark Petrol")
        }
    } else if (wayneDivi <= 0.7) {

        println("$nomeUsuario, é mais barato abastecer com álcool no posto Wayne Oil")
    } else if (starkDivi <= 0.7) {

        println("$nomeUsuario, é mais barato abastecer com álcool no posto Stark Petrol")
    } else {

        if (wayneGaso < starkGaso) {
            println("$nomeUsuario, é mais barato abastecer com gasolina no posto Wayne Oil")
        } else {
            println("$nomeUsuario, é mais barato abastecer com gasolina no posto Stark Petrol")
        }
    }

    main()
}
//--------------------------------------------------------------------------------------------------
fun manutencaoAr() {
    println("GRAND HOTEL BUDAPESTE - MANUTENÇÃO DE AR-CONDICIONADOS")
    println("---------------------------------------------------------------------------------------")

    println("Qual o nome da sua empresa?")
    val nomeEmpresa = readln()

    println("Qual o valor por aparelho?")
    val valorAparelhos = readln().toDouble()

    println("Qual a quantidade de aparelhos?")
    val quantAparelhos = readln().toInt()

    println("Qual a porcentagem de desconto?")
    val porcenDesc = readln().toDouble()

    println("Qual o número mínimo de aparelhos para conseguir o desconto?")
    val numeroMin = readln().toInt()

    val valorTotal = quantAparelhos * valorAparelhos
    val valorDesc = valorTotal * (porcenDesc / 100)
    val valorComDesc = valorTotal - valorDesc

    if (quantAparelhos >= numeroMin) {
        println("O serviço de $nomeEmpresa custará R$ $valorComDesc reais")
    } else {
        println("O serviço de $nomeEmpresa custará R$ $valorTotal reais")
    }

    println("Deseja informar novos dados $nomeUsuario ? S/N")

    val escolha = readln().uppercase()

    when (escolha) {
        "S" -> manutencaoAr()
        "N" -> main()
        else -> {
            println("Desculpe, mas não compreendi.")
        }

    }
}
//--------------------------------------------------------------------------------------------------
fun erro() {
    println("Por favor, informe um número entre 1 e 4")
    main()
}
//_____________________________________________________________________________________________________
fun sair() {
    println("Você deseja sair? S/N")

    val escolha = readln().uppercase()

    when (escolha) {
        "S" -> println("Saindo do sistema...")
        "N" -> main()
        else -> {
            println("Desculpe, mas não compreendi.")
            sair()
        }
    }
    println("Muito obrigado e até logo $nomeUsuario")
}




