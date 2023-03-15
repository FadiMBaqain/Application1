package com.example.myapplication1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var countrySpinner: Spinner
    private lateinit var capitalButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView

    private val countries = listOf(
        "Australia",
        "Brazil",
        "Canada",
        "China",
        "France",
        "Germany",
        "India",
        "Italy",
        "Japan",
        "United States"
    )

    private val capitals = mapOf(
        "Australia" to "Canberra",
        "Brazil" to "Brasília",
        "Canada" to "Ottawa",
        "China" to "Beijing",
        "France" to "Paris",
        "Germany" to "Berlin",
        "India" to "New Delhi",
        "Italy" to "Rome",
        "Japan" to "Tokyo",
        "United States" to "Washington, D.C."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countrySpinner = findViewById(R.id.countryspinner)
        capitalButton = findViewById(R.id.capital)
        clearButton = findViewById(R.id.clear)
        resultTextView = findViewById(R.id.result)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countrySpinner.adapter = adapter

        capitalButton.setOnClickListener { view ->
            val selectedCountry = countrySpinner.selectedItem.toString()
            val capital = capitals[selectedCountry]
            if (capital != null) {
                resultTextView.text = capital
            } else {
                resultTextView.text = "Capital not found for $selectedCountry"
            }
        }

        clearButton.setOnClickListener { view ->
            resultTextView.text = ""
        }
    }
}
