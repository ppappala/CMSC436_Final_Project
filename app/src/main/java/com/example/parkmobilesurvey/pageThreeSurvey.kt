package com.example.parkmobilesurvey

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class pageThreeSurvey : AppCompatActivity() {
    private lateinit var test : TextView
    lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_three_survey)

        test = findViewById(R.id.testText);


        preferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val ans = preferences.getInt("firstAns", 0) // should i put 0

        val selectedItem1 = findViewById<RadioButton>(ans)
        test.text = selectedItem1.text


//        test.setText()

    }
}