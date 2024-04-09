package com.zeller.terminalapp

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
        setContentView(binding.root)
        binding.balance.text = MainViewModel.balance.toString()
    }

    override fun onClick(view: View?) {
        val amt : Float = binding.amountInput.text.toString().toFloat()
        when (view?.id) {
            R.id.withdrawButton -> {
                withdrawFunds(amt)
            }
            R.id.depositButton -> {
                depositFunds(amt)
            }
        }
    }

    // The function take in the current balance and the withdraw amount and checks if there are
    // enough funds and deducts if there is and records the transaction inside MainViewModel
    private fun withdrawFunds(amount : Float) {
        if (!binding.amountInput.text.isNullOrEmpty()) {
            if (MainViewModel.enoughFundsUpdateAmount(amount)) {
                binding.balance.text = MainViewModel.balance.toString()
            } else {
                Toast.makeText(this, "Not enough balance", Toast.LENGTH_LONG).show()
            }
        }
    }

    // This function takes the Deposit amount and updates the balance of the MainViewModel with the
    // new balance and prints the new balance to the textView. It also records the transaction as
    // true for deposited and the amount
    private fun depositFunds(amount: Float) {
        if (!binding.amountInput.text.isNullOrEmpty()) {
            MainViewModel.updateBalance(amount)
            binding.balance.text = MainViewModel.balance.toString()
        }
    }
}