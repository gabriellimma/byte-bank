class ContaCorrente {
    var titular = ""
    var numeroConta = ""
    var documento = ""
    var saldo = 0.0
    var extrato = ""

    fun transferir(contaDestino: ContaCorrente, valorTransferencia: Double) {
        if (valorTransferencia > 0.00) {
            if (isContaCapazTransferir(valorTransferencia)) {
                saldo -= valorTransferencia
                contaDestino.saldo += valorTransferencia
                val saldoAnterior = saldo + valorTransferencia
                extrato =
                    "Transferencia realizada \nconta origem: ${numeroConta} para conta: ${contaDestino.numeroConta}\nvalor: $valorTransferencia\nSaldo anterior R\$$saldoAnterior\nSaldo atual: R\$${saldo}"
                contaDestino.extrato =
                    "Transferencia recebida \nconta origem: ${numeroConta} para conta: ${contaDestino.numeroConta}\nvalor: $valorTransferencia\nSaldo anterior R\$${contaDestino.saldo - valorTransferencia}\nSaldo atual: R\$${contaDestino.saldo}"
                println(extrato)
            } else {
                error("Sua conta nao tem saldo suficiente para esta operacao")
            }
        } else {
            error("valor de transferencia deve ser maior que R\$0.00.")
        }
    }

    fun statusConta(saldoAtual: Double) {
        when {
            saldoAtual > 0.00 -> println("conta positiva")
            saldoAtual == 0.00 -> println("conta neutra")
            saldoAtual < 0.00 -> println("conta negativa")
        }
    }

    fun isContaPositiva(): Boolean {
        return saldo > 0.00
    }

    fun pagarConta(valorPagamento: Double, contaDestino: ContaCorrente) {
        if (isContaPositiva()) {
            saldo -= valorPagamento
            contaDestino.saldo += valorPagamento
        }
    }

    fun isContaCapazTransferir(valorTransferencia: Double): Boolean {
        return saldo >= valorTransferencia
    }

    fun depositar(contaDestino: ContaCorrente, valorDeposito: Double) {
        return if(valorDeposito > 0.00) contaDestino.saldo += valorDeposito
        else error("valor depositado incorreto")
    }

    fun sacar(valorSaque: Double){
        return if (isContaCapazTransferir(valorSaque)) saldo -= valorSaque
        else error("voce nao tem saldo suficiente para esta operacao.")
    }
}