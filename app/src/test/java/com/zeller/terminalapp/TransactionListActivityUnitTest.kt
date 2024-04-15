package com.zeller.terminalapp

import org.junit.Assert.*
import org.junit.Test
import org.junit.Before

class TransactionListActivityUnitTest {

    @Before
    fun setup() {
        MainViewModel.transactions = TransactionsList()
        val amounts = listOf(
            1988.0f,
            123.0f,
            12453.0f,
            1.34f,
            13.0f,
        )
        val deposits = listOf(
            true,
            false,
            true,
            true,
            false
        )

        for (i in amounts.indices) {
            MainViewModel.transactions.addTransaction(
                Transactions(
                    amount = amounts[i],
                    isDeposit = deposits[i]
                ))
        }

    }

    @Test
    fun getDepositWithdraw_correctTransactionType() {
        assertEquals(listOf(
            "deposit",
            "withdraw",
            "deposit",
            "deposit",
            "withdraw",
            ), MainViewModel.getDepositWithdraw())


    }

    @Test
    fun getAmount_correctTransactionAmount() {
        assertEquals(listOf(
            "+$1,988.00",
            "-$123.00",
            "+$12,453.00",
            "+$1.34",
            "-$13.00"
        ), MainViewModel.getAmount())
    }
}