fun main(){
    val titular = "Gabriel Lima"
    val numeroConta = "001"
    val documento = "888.888.888.88"
    var saldo = 20.0
    var extrato = "Sem senhum dado"

    fun transferir(contaSaida: String, contaDestino: String, valorTransferencia: Double){
        if(valorTransferencia > 0.00) {
            if(contaDestino == numeroConta){
                saldo+= valorTransferencia
                val saldoAnterior = saldo - valorTransferencia
                extrato = "Transferencia recebida \nconta origem: $contaSaida\nvalor:$valorTransferencia\nSaldo anterior R\$$saldoAnterior\nSaldo total: R\$$saldo"
                println(extrato)
            } else {
                error("conta destino nao existe")
            }
        } else {
            error("valor de transferencia deve ser maior que R\$0.00.")
        }
    }

    println("Bem vindo ao Bytebank, $titular")
    transferir("10020","001", 17.59)

}