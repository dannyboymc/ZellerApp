package com.zeller.terminalapp

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MainViewModelUnitTest {

    @Before
    fun setup() {
        MainViewModel.balance = 1000.0f
    }

    @Test
    fun testEnoughFundsUpdateAmount_EnoughFunds() {
        // Arrange
        val withdrawAmount = 1000.0f

        // Act
        val result = MainViewModel.enoughFundsUpdateAmount(withdrawAmount)

        // Assert
        assertEquals(true, result)
        assertEquals(0.0f, MainViewModel.balance)
        // Assuming transactions are being added correctly, you might also test the transactions list here.
    }

    @Test
    fun testEnoughFundsUpdateAmount_NotEnoughFunds() {
        // Arrange
        val withdrawAmount = 1500.0f

        // Act
        val result = MainViewModel.enoughFundsUpdateAmount(withdrawAmount)

        // Assert
        assertEquals(false, result)
        assertEquals(1000.0f, MainViewModel.balance)
        // Assuming transactions are not added when there are not enough funds, you might also test the transactions list here.
    }
}