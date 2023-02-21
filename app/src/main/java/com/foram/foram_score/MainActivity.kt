package com.foram.foram_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerScoreValues: Spinner
    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView
    private lateinit var switch: SwitchCompat

    // Array of integers to display score values in the spinner view
    private var scoreValues = arrayOf("Select Score Value", "1", "2", "3", "4", "5", "6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Function to initialize views with their IDs.
        initViews()

        // Create the adapter to show dropdown menu
        val adapter = ArrayAdapter(this, R.layout.score_dropdown_menu, scoreValues)
        // Setting the adapter to the instance of Spinner View
        spinnerScoreValues.adapter = adapter

        tvScoreA.text = "0"
        tvScoreB.text = "0"

        switch.setOnCheckedChangeListener { _, isChecked ->
            val message: String = if (isChecked) "You have selected Team B for scoring"
            else "You have selected Team A for scoring"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }

    }

    private fun initViews() {
        spinnerScoreValues = findViewById(R.id.spinner_score_values)

        tvScoreA = findViewById(R.id.tv_score_a)
        tvScoreB = findViewById(R.id.tv_score_b)

        switch = findViewById(R.id.switch_to_change)
    }
}