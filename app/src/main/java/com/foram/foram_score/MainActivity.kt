package com.foram.foram_score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.foram.foram_score.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    // Array of integers to display score values in the spinner view
    private var scoreValues = arrayOf("Select Score Value", "1", "2", "3", "4", "5", "6")

    // integer value to increase and decrease scores
    private var valueToIncDec = 0

    // Set default scoring team as A
    private var isScoringTeamA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create the adapter to show dropdown menu
        val adapter = ArrayAdapter(this, R.layout.score_dropdown_menu, scoreValues)
        // Setting the adapter to the instance of Spinner View
        binding.spinnerScoreValues.adapter = adapter

        // Spinner OnItemSelectedListener
        binding.spinnerScoreValues.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(p0: AdapterView<*>?) {

                }

                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    valueToIncDec = when (p2) {         // Setting var valueToIncDec value when spinner item is selected
                        0 -> {
                            printToastMessage("Please select any score value.")
                            0
                        }
                        else -> {
                            scoreValues[p2].toInt()
                        }
                    }
                }
            }

        // Set the initial score to both the teams as var "valueToIncDec"
        binding.tvScoreA.text = valueToIncDec.toString()
        binding.tvScoreB.text = valueToIncDec.toString()

        // Switch change listener to pass message when switch changes it's state
        binding.switchToChange.setOnCheckedChangeListener { _, isChecked ->
            val message: String = if (isChecked) "You have selected Team B for scoring"
            else "You have selected Team A for scoring"

            isScoringTeamA = !isChecked         // Set isScoringTeamA as true or false when switch is check or unchecked respectively
            printToastMessage(message)
        }

        // Increase Button On Click Event
        binding.btnIncrease.setOnClickListener {
            val incrementValue: Int
            if (valueToIncDec <= 0) {
                printToastMessage("Please select scoring value first.")
            } else {
                if (isScoringTeamA) {
                    incrementValue =
                        Integer.parseInt(binding.tvScoreA.text as String) + valueToIncDec

                    // Set incremented value to the scoring textView of team A
                    binding.tvScoreA.text = incrementValue.toString()
                } else {
                    incrementValue =
                        Integer.parseInt(binding.tvScoreB.text as String) + valueToIncDec

                    // Set incremented value to the scoring textView of team B
                    binding.tvScoreB.text = incrementValue.toString()
                }
            }
        }

        // Decrease Button On Click Event
        binding.btnDecrease.setOnClickListener {
            val decrementValue: Int
            if (valueToIncDec <= 0) {
                printToastMessage("Please select scoring value first.")
            } else {
                if (isScoringTeamA) {
                    decrementValue =
                        Integer.parseInt(binding.tvScoreA.text as String) - valueToIncDec
                    if (decrementValue >= 0){
                        // Set decremented value to the scoring textView of team A
                        binding.tvScoreA.text = decrementValue.toString()
                    }
                    else printToastMessage("Score value can not be negative.")
                } else {
                    decrementValue =
                        Integer.parseInt(binding.tvScoreB.text as String) - valueToIncDec
                    if (decrementValue >= 0) {
                        // Set decremented value to the scoring textView of team B
                        binding.tvScoreB.text = decrementValue.toString()
                    }
                    else printToastMessage("Score value can not be negative.")
                }
            }
        }
    }

    // Function to print Toast Message
    private fun printToastMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}