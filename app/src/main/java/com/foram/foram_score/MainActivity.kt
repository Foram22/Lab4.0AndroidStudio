package com.foram.foram_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerScoreValues: Spinner
    private lateinit var tvScoreA: TextView
    private lateinit var tvScoreB: TextView

    // Array of integers to display score values in the spinner view
    private var scoreValues = arrayOf("Select Score Value", "1", "2", "3", "4", "5", "6")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Function to initialize views with their IDs.
        initViews()

        // Create the adapter to show dropdown menu
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, scoreValues)
        // Setting the adapter to the instance of Spinner View
        spinnerScoreValues.adapter = adapter

        spinnerScoreValues.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }

        tvScoreA.text = "0"
        tvScoreB.text = "0"

    }

    private fun initViews() {
        spinnerScoreValues = findViewById(R.id.spinner_score_values)

        tvScoreA = findViewById(R.id.tv_score_a)
        tvScoreB = findViewById(R.id.tv_score_b)
    }
}