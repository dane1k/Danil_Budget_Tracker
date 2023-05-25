package com.example.danil_budgettracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.translationMatrix
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.danil_budgettracker.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var transactions: ArrayList<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        transactions = arrayListOf(
            Transaction("Weekend Budget", 50.00),
            Transaction("Countdown", -54.17),
            Transaction("TaiPing", -28.78),
            Transaction("Caffe", -5.20),
            Transaction("Steam", -25.49),
            Transaction("SkinsCsgo", 150.38),
            Transaction("SkateShop", -55.00),
        )

        transactionAdapter = TransactionAdapter(transactions)
        binding.recyclerview.adapter = transactionAdapter
    }

    private fun updateDashboard(){
        val totalAmount = transactions.map { it.amount }.sum()
        val budgetAmount = transactions.filter { it.amount > 0 }.map { it.amount }.sum()
        val expanseAmount = totalAmount - budgetAmount

    }
}

