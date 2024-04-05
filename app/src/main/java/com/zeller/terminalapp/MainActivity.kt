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
    }

    override fun onClick(view: View?) {
        var amt = 0f
        when (view?.id) {
            //deducts funds from balance if the field isn't empty and will check if there is enough
            //funds to deduct, if there is enough funds it'll record the successful deduction and
            //update the the balance. If there isn't enough funds it'll make a toast displaying
            //not enough funds
            R.id.withdrawButton -> {
                val balance = MainViewModel.balance
                if (!binding.amountInput.text.isNullOrEmpty()) {
                    amt = binding.amountInput.text.toString().toFloat()
                    if (balance >= amt) {
                        MainViewModel.balance -= amt
                        binding.balance.text = MainViewModel.balance.toString()
                        MainViewModel.transactions.addTransaction(
                            Transactions(
                                isDeposit = false,
                                amount = amt
                            )
                        )
                    } else {
                        Toast.makeText(this, "Not enough balance", Toast.LENGTH_LONG).show()
                    }
                }
            }

            R.id.depositButton -> {
                if (!binding.amountInput.text.isNullOrEmpty()) {
                    amt = binding.amountInput.text.toString().toFloat()
                    MainViewModel.balance += amt
                    binding.balance.text = MainViewModel.balance.toString()
                    MainViewModel.transactions.addTransaction(
                        Transactions(
                            isDeposit = true,
                            amount = amt
                        )
                    )
                }
            }
        }
    }
}