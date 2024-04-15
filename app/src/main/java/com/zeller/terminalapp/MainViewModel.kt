package com.zeller.terminalapp

object MainViewModel {

    var balance = 0.0f
    var transactions: TransactionsList = TransactionsList()

    /*
    * This method takes a float as the input and if there are enough funds it updates the the current
    * balance and adds the transaction to the transaction list
    */
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
    /*
    * The update balance take the amount in the deposit amount as a float and takes the current
    * balance in this object and returns the updated balance as a float
    */
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

    /*
    * the getDepositWithdraw method returns a list of strings of all the current deposited or
    * withdrawn transactions
    */
    fun getDepositWithdraw() : List<String> {
        val depositWithdrawList = mutableListOf<String>()
        transactions.getTransactionsList().forEach { transaction ->
            val type = if (transaction.first) "deposit" else "withdraw"
            depositWithdrawList.add(type)
        }
        return depositWithdrawList
    }

    /*
    * the getAmount method returns a list of strings of all the current amounts in the transactions
    */
    fun getAmount(): List<String> {
        return transactions.getTransactionsList().map { transaction ->
            val (isDeposit, amount) = transaction
            val prefix = if (isDeposit) "+" else "-"
            "$prefix${formatToDollarStyle(amount)}"
        }
    }
}
