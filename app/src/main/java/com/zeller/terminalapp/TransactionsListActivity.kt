package com.zeller.terminalapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.Locale


class TransactionsListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<TransactionDataClass>
    private lateinit var depositList: List<String>
    private lateinit var amountList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transactions)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        depositList = MainViewModel.getDepositWithdraw().reversed()
        amountList = MainViewModel.getAmount().reversed()

        recyclerView = findViewById(R.id.recyclerViewTransactions)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()

        getData()

    }

    private fun getData() {
        for (i in depositList.indices) {
            val dataClass = TransactionDataClass(depositList[i], amountList[i])
            dataList.add(dataClass)
        }
        recyclerView.adapter = TransactionAdapterClass(dataList)
    }

}

fun formatToDollarStyle(value: Float): String {
    val formatter = NumberFormat.getCurrencyInstance(Locale.US)
    return formatter.format(value.toDouble())
}