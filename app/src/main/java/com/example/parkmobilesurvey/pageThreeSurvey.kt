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

        val intent1= intent

        val parkName = intent1.getStringExtra("park")
        val firstAns = intent1.getStringExtra("A1")
        val secondAns = intent1.getStringExtra("A2")
        val thirdAns = intent1.getStringExtra("A3")
        val fourthAns = intent1.getStringExtra("A4")
        val fifthAns = intent1.getStringExtra("A5")


        //editText = findViewById(R.id.editText)
        test = findViewById(R.id.testText)
        test.text ="place the text here"

//        val sixthAns = editText.text
//        if(sixthAns.length == 0) {
//            Toast.makeText(this, "You must enter feedback", Toast.LENGTH_SHORT).show()
//        }
//        else{
//            Toast.makeText(this, "Survey answers saved", Toast.LENGTH_SHORT).show()
//        }


    }
}