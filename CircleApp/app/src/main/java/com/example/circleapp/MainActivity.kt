package com.example.circleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.PI

class MainActivity : AppCompatActivity() {

    private lateinit var radiusInput: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radiusInput = findViewById(R.id.radiusInput)
        calculateButton = findViewById(R.id.calculateButton)
        resultText = findViewById(R.id.resultText)

        calculateButton.setOnClickListener {
            calculateArea()
        }
    }

    private fun calculateArea() {
        val radiusString = radiusInput.text.toString()

        if (radiusString.isEmpty()) {
            Toast.makeText(this, "Please enter a radius value", Toast.LENGTH_SHORT).show()
            return
        }

        val radius = radiusString.toDoubleOrNull()
        if (radius == null) {
            Toast.makeText(this, "Invalid number entered", Toast.LENGTH_SHORT).show()
            return
        }

        val area = PI * radius * radius

        resultText.text = String.format("Area: %.2f square units", area)
    }
}
