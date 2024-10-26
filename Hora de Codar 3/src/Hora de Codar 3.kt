fun main(){
    inicio()
}
fun inicio(){
    println("escolha sua lição: ")
    println("Lição -> 1")
    println("Lição -> 2")
    println("Lição -> 3")
    println("Lição -> 4")
    println("Lição -> 5")
    println("Lição -> 6")
    println("Lição -> 7")
    println("Lição -> 8")
    println("Lição -> 9")
    println("Lição -> 10")
    var licao = readln().toInt()
    when(licao){
        1 -> l1()
        2 -> l2()
        3 -> l3()
        4 -> l4()
        5 -> l5()
        6 -> l6()
        7 -> l7()
        8 -> l8()
        9 -> l9()
        10 -> l10()
    }
}
fun l1() {
    println("informe o 1° numero: ")
    var n1 = readln().toInt()
    var n2: Int
    do {
        println("informe o 2° valor: ")
        n2 = readln().toInt()
    } while (n2 <= 0)
    var some = n1 / n2
    println("o Resultado da divisão do $n1 pelo $n2 é $some.")
    inicio()
}
fun l2(){
    var contador: Int = 30
    do {
        println("contagem regressiva de: $contador")
        contador --
        Thread.sleep(200)
    } while (contador > 0 )
    println("Booooom")
    inicio()
}
fun l3(){
    var numeros: Int = 10
    do {
        println(numeros)
        numeros --
    } while (numeros > 0 )
    println("os numeros foram impressos!")
        inicio()
}
fun l4(){
    //Faça um algoritmo que calcule e escreva a média aritmética dos números inteiros entre 15 (inclusive) e 100 (inclusive).
    var soma = 0
    var quantidade = 0
    for (i in 15..100){
        soma += i
        quantidade ++
    }
   val media = soma.toDouble() / quantidade
    println("a média aritmética dos numeros é $media")
inicio()
}
fun l5(){
    println("Informe um numero:")
    var n1 = readln().toInt()
    println("informe outro numero: ")
    var n2 = readln().toInt()

    print("a media aritmetica dos numeros informados é: ${(n1 + n2) / 2 }")
}
var quantidade = 0
fun l6(){
    println("Informe uma nota:")
    var n1 = readln().toInt()
    println("Informe a segunda nota:")
    var n2 = readln().toInt()
    var soma = (n1 + n2) / 2
    if (soma >= 9.5){
        println("o individuo é brabo tirou $soma")
        quantidade ++

        println("a quantidade de alunos aprovados é: $quantidade")
    } else { println("o individuo é burro")}
 println("Calcular a média de outro aluno Sim/Não?")
 var sn = readln()
    if (sn == "Sim" || sn == "sim") l6()
    else inicio()
}
fun l7(){
    var nota: Int
    var soma = 0

     for (i in 1..6) {
        do {
            println("Informe a nota $i (de 0 a 10):")
            nota = readln().toInt()
            if (nota < 0 || nota > 10) {
                println("Nota inválida. Por favor, insira uma nota entre 0 e 10.")
            }
        } while (nota < 0 || nota > 10)

        soma += nota
     }
    val media = soma / 6
    if (media >= 9.5) {
        println("O aluno foi aprovado com média $media")
    } else {
        println("O aluno não foi aprovado.")
    }
}

fun l8(){
    // Ler um valor N e imprimir todos os valores inteiros entre 1 (inclusive) e N (inclusive). Considere que o N será sempre maior que ZERO.
    //N  é um valor informado pelo usuário
        print("Por favor, insira um número maior que zero para ver a contagem: ")
        val n = readLine()?.toIntOrNull() ?: return println("O numero inserido é um número inválido.")
        println("\nContagem de 1 até $n:")
        for (i in 1..n) {
            print("$i ")
            Thread.sleep(500)
        }
        println("\nTerminamos a contagem!")
    }

fun l9() {
    // Escreva um algoritmo para imprimir os 10 primeiros números inteiros maiores que 100.

    var numero = 100
    println("Os 10 números maiores que 100, são:")
    while (numero <= 110) {

        Thread.sleep(400)
        println("$numero")

        numero = numero + 1

    }
}
    fun l10(){
        print("Informe o valor para gerar a tabuada (o valor deve ser maior que zero): ")
        val n1 = readLine()!!.toInt()

        if (n1 > 0) {
            for (i in 1..n1) {
                println("Tabuada do $i:")
                for (j in 1..10) {
                    println("$i x $j = ${i * j}")
                }
                println()
            }
        } else {
            println("O valor deve ser maior que zero.")
        }
    }

fun l11() {
    fun main() {
        var dentro = 0
        var fora = 0
        val totalValores = 10
        for (i in 1..totalValores) {
            println("Informe o valor $i:")
            val numero = readLine()?.toIntOrNull() ?: continue
            when {
                numero in 24..42 -> {
                    dentro++
                }
                else -> {
                    fora++
                }
            }
        }
        println("Total de valores dentro do intervalo [24, 42]: $dentro")
        println("Total de valores fora do intervalo [24, 42]: $fora")
    }

}

