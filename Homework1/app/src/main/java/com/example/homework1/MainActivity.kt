package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //  widget variable declarations
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText

    lateinit var concatButton: Button
    lateinit var addButton: Button

    lateinit var outputStringTextView: TextView
    lateinit var outputNumericTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//      widget varibles instantiated
        firstNameEditText = findViewById(R.id.first_name_edittext)
        lastNameEditText = findViewById(R.id.last_name_edittext)

        Log.d("JS", firstNameEditText.toString())
        Log.d("JS", lastNameEditText.toString())

        concatButton = findViewById(R.id.concat_button)
        addButton = findViewById(R.id.add_button)

        outputStringTextView = findViewById(R.id.string_output_textView)
        outputNumericTextView = findViewById(R.id.numeric_output_textView)


//      Click listener for contcat button
        concatButton.setOnClickListener {
            val outputString: String = "${firstNameEditText.text} ${lastNameEditText.text}"

            outputStringTextView.text = outputString
            outputStringTextView.visibility = View.VISIBLE

            Log.d("JS", outputString.toString())
        }

//      Click listener for add button
        addButton.setOnClickListener {

            var firstNum:Double
            var nextNum:Double

//          Catch if input is blank or not a number
            firstNum = if (firstNameEditText.text.toString().toDoubleOrNull() != null) firstNameEditText.text.toString().toDouble() else 0.0
            nextNum = if (lastNameEditText.text.toString().toDoubleOrNull() != null) lastNameEditText.text.toString().toDouble() else 0.0

            val addedNums: String =
                (firstNum + nextNum).toString()


            outputNumericTextView.text = addedNums
            outputNumericTextView.visibility = View.VISIBLE

            Log.d("JS", addedNums.toString())
        }
    }

}
