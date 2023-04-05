package com.example.calculatorapp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var _calculatorInputTextView: TextView? = null
    var isLastCharacterNumeric: Boolean = false
    var isLastCharacterDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        // Define ActionBar object
        // Define ActionBar object
        val actionBar: ActionBar? = supportActionBar

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter

        // Define ColorDrawable object and parse color
        // using parseColor method
        // with color hash code as its parameter
        val colorDrawable = ColorDrawable(Color.parseColor("#90a4ae"))

        // Set BackgroundDrawable

        // Set BackgroundDrawable
        actionBar?.setBackgroundDrawable(colorDrawable)

        _calculatorInputTextView =  findViewById<TextView>(R.id.textViewInputField)
    }

    fun onDigit(view: View){

        _calculatorInputTextView?.append((view as Button).text)

        isLastCharacterNumeric = true
        isLastCharacterDot = false

        //Toast.makeText(this, "Toast displayed", Toast.LENGTH_LONG ).show()
    }

    fun onClear(view: View){
        _calculatorInputTextView?.text = ""
    }

    fun onDecimalPoint (view: View){
        if (isLastCharacterNumeric && !isLastCharacterDot){
            _calculatorInputTextView?.append(".")
            isLastCharacterNumeric = false
            isLastCharacterDot = true
        }
    }

    fun onOperator(view: View){
        _calculatorInputTextView?.text?.let {

            if (isLastCharacterNumeric && !isOperatorAdded(it.toString()) ){
                _calculatorInputTextView?.append((view as Button).text)

                isLastCharacterNumeric = false
                isLastCharacterDot = false
            }
        }
    }

    private fun isOperatorAdded(value: String) : Boolean {
        return if (value.startsWith("-") ){
            true
        }else value.contains("-") || value.contains("+") || value.contains("*") || value.contains("/")
    }


}