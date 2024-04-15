package com.zeller.terminalapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.zeller.terminalapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.depositButton.setOnClickListener(this)
        binding.withdrawButton.setOnClickListener(this)
        binding.transactionButton.setOnClickListener(this)
        setContentView(binding.root)
        binding.balance.text = formatToDollarStyle(MainViewModel.balance)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.withdrawButton -> {
                withdrawFunds()
            }
            R.id.depositButton -> {
                depositFunds()
            }
            R.id.transactionButton -> {
                // Create an Intent to navigate to the TransactionsListActivity
                val intent = Intent(this, TransactionsListActivity::class.java)
                // Start the TransactionsListActivity
                startActivity(intent)
            }
        }
    }

    // The function take in the current balance and the withdraw amount and checks if there are
    // enough funds and deducts if there is and records the transaction inside MainViewModel
    private fun withdrawFunds() {
        if (!binding.amountInput.text.isNullOrEmpty()) {
            if (MainViewModel.enoughFundsUpdateAmount(binding.amountInput.text.toString().toFloat())) {
                binding.balance.text = formatToDollarStyle(MainViewModel.balance)
            } else {
                Toast.makeText(this, "Not enough balance", Toast.LENGTH_LONG).show()
            }
        }
    }

    // This function takes the Deposit amount and updates the balance of the MainViewModel with the
    // new balance and prints the new balance to the textView. It also records the transaction as
    // true for deposited and the amount
    private fun depositFunds() {
        if (!binding.amountInput.text.isNullOrEmpty()) {
            MainViewModel.updateBalance(binding.amountInput.text.toString().toFloat())
            binding.balance.text = formatToDollarStyle(MainViewModel.balance)
        }
    }
}