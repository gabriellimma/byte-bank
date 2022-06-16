class ContaCorrente {
    var titular = ""
    var numeroConta = ""
    var documento = ""
    var saldo = 0.0
    var extrato = ""

    fun transferir(contaOrigem: ContaCorrente, contaDestino: ContaCorrente, valorTransferencia: Double) {
        if (valorTransferencia > 0.00) {
            if (isContaCapazTransferir(contaOrigem, valorTransferencia)) {
                contaOrigem.saldo -= valorTransferencia
                contaDestino.saldo += valorTransferencia
                val saldoAnterior = contaOrigem.saldo + valorTransferencia
                contaOrigem.extrato =
                    "Transferencia realizada \nconta origem: ${contaOrigem.numeroConta} para conta: ${contaDestino.numeroConta}\nvalor: $valorTransferencia\nSaldo anterior R\$$saldoAnterior\nSaldo atual: R\$${contaOrigem.saldo}"
                contaDestino.extrato =
                    "Transferencia recebida \nconta origem: ${contaOrigem.numeroConta} para conta: ${contaDestino.numeroConta}\nvalor: $valorTransferencia\nSaldo anterior R\$${contaDestino.saldo - valorTransferencia}\nSaldo atual: R\$${contaDestino.saldo}"
                println(contaOrigem.extrato)
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

    fun isContaPositiva(contaOrigem: ContaCorrente): Boolean {
        return contaOrigem.saldo > 0.00
    }

    fun pagarConta(valorPagamento: Double, contaOrigem: ContaCorrente, contaDestino: ContaCorrente) {
        if (isContaPositiva(contaOrigem)) {
            contaOrigem.saldo -= valorPagamento
            contaDestino.saldo += valorPagamento
        }
    }

    fun isContaCapazTransferir(contaOrigem: ContaCorrente, valorTransferencia: Double): Boolean {
        return contaOrigem.saldo >= valorTransferencia
    }
}