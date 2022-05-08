package com.example.parkmobilesurvey

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*


class pageTwoSurvey : AppCompatActivity() {

    private lateinit var previous1: Button
    private lateinit var next2: Button
    private lateinit var group3: RadioGroup
    private lateinit var group4: RadioGroup
    private lateinit var group5: RadioGroup


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two_survey)

        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        previous1 = findViewById(R.id.previous1)
        next2 = findViewById(R.id.next2)
        group3 = findViewById(R.id.radioGroup3)
        group4 = findViewById(R.id.radioGroup4)
        group5 = findViewById(R.id.radioGroup5)



        next2.setOnClickListener {
            //go to next page

            //the checked radio button for third quesiton
            val checkedRadio3: Int = group3.checkedRadioButtonId

            //the checked radio button for fourth quesiton
            val checkedRadio4: Int = group4.checkedRadioButtonId

            //the checked radio button for fifth quesiton
            val checkedRadio5: Int = group5.checkedRadioButtonId

            val editor: SharedPreferences.Editor = sharedPreferences.edit()


            editor.putInt("thirdAns", checkedRadio3)
            editor.putInt("fourthAns", checkedRadio4)
            editor.putInt("fourthAns", checkedRadio4)
            editor.putInt("fifthAns", checkedRadio5);

            editor.apply()

            val intent = Intent(this, pageThreeSurvey::class.java)
            startActivity(intent)

        }


//        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = mPreferences.edit();








    }
}