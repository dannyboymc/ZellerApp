package com.zeller.terminalapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// RecyclerView TransactionAdapterClass - Overrides the current adapter to allow for our custom data
class TransactionAdapterClass(private val dataList: ArrayList<TransactionDataClass>) :
    RecyclerView.Adapter<TransactionAdapterClass.ViewHolderClass>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction_layout, parent, false)
        return ViewHolderClass(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val currentItem = dataList[position]
        holder.depositWithdraw.text = currentItem.dataDeposit
        holder.amount.text = currentItem.dataAmount
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val depositWithdraw: TextView = itemView.findViewById(R.id.depositwithdraw)
        val amount: TextView = itemView.findViewById(R.id.amount)
    }
}