package com.example.surverypart2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.parkmobilesurvey.R

class SurveyPage2 : AppCompatActivity() {
    private lateinit var previous1: Button
    private lateinit var next2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pageTwoDesign);

        previous1 = findViewById(R.id.previous1)
        next2 = findViewById(R.id.next2)




    }
}