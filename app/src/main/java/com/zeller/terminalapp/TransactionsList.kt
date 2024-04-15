package com.zeller.terminalapp

class TransactionsList {
    private val transactionsList: MutableList<Transactions> = mutableListOf()
    fun addTransaction(transactions: Transactions) {
        transactionsList.add(transactions)
    }

    fun getTransactionsList(): List<Pair<Boolean, Float>> {
        return transactionsList.map { it.isDeposit to it.amount }
    }
}
