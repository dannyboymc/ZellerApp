package com.zeller.terminalapp


import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*

import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun withdrawFunds_sufficientBalance_withdrawsCorrectly() {
        // Arrange
        val initialBalance = 100.0f
        onView(withId(R.id.amountInput)).perform(replaceText(initialBalance.toString()))
        onView(withId(R.id.depositButton)).perform(click())

        // Act
        val withdrawAmount = 50.0f
        onView(withId(R.id.amountInput)).perform(replaceText(withdrawAmount.toString()))
        onView(withId(R.id.withdrawButton)).perform(click())

        // Assert
        println("Text is: " + (initialBalance - withdrawAmount).toString())
        onView(withId(R.id.balance)).check(matches(withText((initialBalance - withdrawAmount).toString())))
        // You might also want to check that the transaction has been recorded correctly in the MainViewModel
    }

    @Test
    fun withdrawFunds_insufficientBalance_showsToast() {
        // Arrange
        val initialBalance = 20.0f
        val withdrawAmount = 50.0f
        onView(withId(R.id.amountInput)).perform(replaceText(withdrawAmount.toString()))

        // Act
        onView(withId(R.id.withdrawButton)).perform(click())

        // Assert
        onView(withText("Not enough balance"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))      // You might also want to check that the balance remains unchanged and no transaction is recorded
    }
}