package com.example.parkmobilesurvey

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class pageThreeSurvey : AppCompatActivity() {
    private lateinit var test : TextView
    private lateinit var editText : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_three_survey)

        val parkName = intent.getStringExtra("park")
        val firstAns = intent.getStringExtra("A1")
        val secondAns = intent.getStringExtra("A2")
        val thirdAns = intent.getStringExtra("A3")
        val fourthAns = intent.getStringExtra("A4")
        val fifthAns = intent.getStringExtra("A5")


        editText = findViewById(R.id.editText)

        val sixthAns = editText.text
        if(sixthAns.length == 0) {
            Toast.makeText(this, "You must enter feedback", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Survey answers saved", Toast.LENGTH_SHORT).show()
        }










    }
}