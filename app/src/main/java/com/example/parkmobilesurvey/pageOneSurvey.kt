package com.example.parkmobilesurvey

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class pageOneSurvey : AppCompatActivity() {
    private lateinit var group1: RadioGroup
    private lateinit var radio1: RadioButton
    private lateinit var group2: RadioGroup
    private lateinit var radio2: RadioButton
    private lateinit var next: Button

    private lateinit var complete: TextView

    //added by keya
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one_survey)
    // shared pref added by keya
        sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);

        group1 = findViewById(R.id.radioGroup)
        group2 = findViewById(R.id.radioGroup2)


        complete = findViewById(R.id.textView6)
        next = findViewById(R.id.next)

        next.setOnClickListener{

            val check1 = group1.checkedRadioButtonId
            val check2 = group2.checkedRadioButtonId

    // added by keya
            //the checked radio button for first quesiton
            val checkedRadio: Int = group1.checkedRadioButtonId

            //the checked radio button for second quesiton
            val checkedRadio2: Int = group2.checkedRadioButtonId

            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putInt("firstAns", checkedRadio)
            editor.putInt("secondAns", checkedRadio2)
            editor.apply();

            //-----------------
            if(check1 < 0 || check2< 0){
                Toast.makeText(this, "you must click all question", Toast.LENGTH_SHORT).show()

            }else{
                complete.text = check1.toString() + check2.toString()

            }

            val intent = Intent(this, pageTwoSurvey::class.java)

            startActivity(intent)


        }


    }
}