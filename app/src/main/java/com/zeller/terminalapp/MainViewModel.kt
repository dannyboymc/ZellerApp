package com.zeller.terminalapp


object MainViewModel {
    var balance = 0.0f
    var transactions: TransactionsList = TransactionsList()

    fun enoughFundsUpdateAmount(withdrawAmount : Float) : Boolean {
        return if (withdrawAmount <= balance) {
            balance -= withdrawAmount
            transactions.addTransaction(
                Transactions(
                    isDeposit = false,
                    amount = withdrawAmount
                )
            )
            true
        }   else {
            false
        }
    }

    fun updateBalance (depositAmount: Float) : Float {
        balance += depositAmount
        transactions.addTransaction(
            Transactions(
                isDeposit = true,
                amount = depositAmount
            )
        )
        return balance
    }
}
