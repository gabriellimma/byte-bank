fun main(){
    val contaGabriel = ContaCorrente()
    contaGabriel.titular = "Gabriel Lima"
    contaGabriel.numeroConta = "0001"
    contaGabriel.documento = "1010"
    contaGabriel.saldo = 100.00

    val contaNeuza = ContaCorrente()
    contaNeuza.titular = "Neuza Silva"
    contaNeuza.numeroConta = "0002"
    contaNeuza.documento = "1011"
    contaNeuza.saldo = 00.00

    println("Bem vindo ao Bytebank, ${contaGabriel.titular}")
    contaGabriel.transferir(contaGabriel, contaNeuza, 101.00)
    print(contaNeuza.extrato)
    contaGabriel.isContaPositiva(contaGabriel)

}

