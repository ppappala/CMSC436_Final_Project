package com.example.parkmobilesurvey

import android.content.Intent
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
    private lateinit var parkname: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_one_survey)
        group1 = findViewById(R.id.radioGroup)
        group2 = findViewById(R.id.radioGroup2)


        complete = findViewById(R.id.textView6)
        parkname = findViewById(R.id.textView11)
        val intent = intent
        val parknaame = intent.getStringExtra("park")
        parkname.text ="From "+ parknaame
        next = findViewById(R.id.next)

        next.setOnClickListener{

            val check1 = group1.checkedRadioButtonId
            val check2 = group2.checkedRadioButtonId


            if(check1 < 0 || check2< 0){
                Toast.makeText(this, "You must answer all the questions", Toast.LENGTH_SHORT).show()

            }else{
                complete.text = check1.toString() + check2.toString()
                // create Intent here
                val intent = Intent(this, pageTwoSurvey::class.java)
                radio1 = findViewById(check1)
                radio2 = findViewById(check2)

                val firstAns = radio1.text
                val secondAns = radio2.text
                intent.putExtra("park", parknaame)
                intent.putExtra("A1", firstAns)
                intent.putExtra("A2", secondAns)
                startActivity(intent)

                // maybe use radiobutton variable = findViewByid(check1)
                // and radiobutton variable2 = findViewByid(check2)
                // save those variable in the intent (the string name of the button)
                // Then start acitvity 2 for the second page


            }
        }


    }
}