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
    private lateinit var radio3: RadioButton
    private lateinit var radio4: RadioButton
    private lateinit var radio5: RadioButton
    private lateinit var group6: RadioGroup
    private lateinit var radio6: RadioButton
    private lateinit var group8: RadioGroup
    private lateinit var radio8: RadioButton

    private lateinit var stars: RatingBar

    // added back radiogroup 5 and button


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two_survey)

        next2 = findViewById(R.id.next2)
        group3 = findViewById(R.id.radioGroup3)
        group4 = findViewById(R.id.radioGroup4)
        group5 = findViewById(R.id.radioGroup5)
        group6 = findViewById(R.id.radioGroup6)
        group8 = findViewById(R.id.radioGroup8)

        stars = findViewById(R.id.ratingBar)




        next2.setOnClickListener {

            val check3: Int = group3.checkedRadioButtonId

            //the checked radio button for fourth quesiton

            val check4: Int = group4.checkedRadioButtonId

            //the checked radio button for fifth quesiton

            val check5: Int = group5.checkedRadioButtonId //uncommented

            val check6: Int = group6.checkedRadioButtonId

            val check7: Float = stars.rating

            val check8: Int = group8.checkedRadioButtonId




            val intent2 = intent
// zero stars is allowed
            if(check3 < 0 || check4 < 0 || check5 < 0 || check6 < 0 || check8 < 0) {
                Toast.makeText(this, "You must answer all the questions", Toast.LENGTH_SHORT).show()

            }else {
                radio3 = findViewById(check3)
                radio4 = findViewById(check4)
                radio5 = findViewById(check5) //
                radio6 = findViewById(check6)
                radio8 = findViewById(check8)


                val thirdAns = radio3.text
                val fourthAns = radio4.text
                val fifthAns = radio5.text //
                val sixthAns = radio6.text
                val eighthAns = radio8.text
                val parkName = intent2.getStringExtra("park")
                val firstAns = intent2.getStringExtra("A1") //from previous activity
                val secondAns = intent2.getStringExtra("A2")


                val intent1 = Intent(this, pageThreeSurvey::class.java)

                intent1.putExtra("park", parkName)
                intent1.putExtra("A1", firstAns)
                intent1.putExtra("A2", secondAns)
                intent1.putExtra("A3", thirdAns)
                intent1.putExtra("A4", fourthAns)
                intent1.putExtra("A5", fifthAns) // uncommented
                intent1.putExtra("A6", sixthAns)
                intent1.putExtra("A7", check7) // passed in number of stars
                intent1.putExtra("A8", check8)
                startActivity(intent1)
            }

        }


//        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        SharedPreferences.Editor editor = mPreferences.edit();





    }
}


//package com.example.parkmobilesurvey
//
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.provider.MediaStore
//import android.widget.*
//
//
//class pageTwoSurvey : AppCompatActivity() {
//
//    private lateinit var previous1: Button
//    private lateinit var next2: Button
//    private lateinit var group3: RadioGroup
//    private lateinit var group4: RadioGroup
//    private lateinit var group5: RadioGroup
//    private lateinit var radio3: RadioButton
//    private lateinit var radio4: RadioButton
//    private lateinit var radio5: RadioButton
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_page_two_survey)
//
//
////        previous1 = findViewById(R.id.previous1)
////        next2 = findViewById(R.id.next2)
//        group3 = findViewById(R.id.radioGroup3)
//        group4 = findViewById(R.id.radioGroup4)
////        group5 = findViewById(R.id.radioGroup5)
//
//
//
//        next2.setOnClickListener {
//
//                //the checked radio button for third quesiton
//                val check3: Int = group3.checkedRadioButtonId
//
//                //the checked radio button for fourth quesiton
//                val check4: Int = group4.checkedRadioButtonId
//
//                //the checked radio button for fifth quesiton
//                val check5: Int = group5.checkedRadioButtonId
//
////                val intent = Intent(this, pageThreeSurvey::class.java)
//
//            if(check3 < 0 || check4 < 0 || check5 < 0){
//                Toast.makeText(this, "You must answer all the questions", Toast.LENGTH_SHORT).show()
//
//            }else {
//                radio3 = findViewById(check3)
//                radio4 = findViewById(check4)
//                radio5 = findViewById(check5)
//
//                val thirdAns = radio3.text
//                val fourthAns = radio4.text
//                val fifthAns = radio5.text
//                val parkName = intent.getStringExtra("park")
//                val firstAns = intent.getStringExtra("A1")
//                val secondAns = intent.getStringExtra("A2")
//
//                intent.putExtra("park", parkName)
//                intent.putExtra("A1", firstAns)
//                intent.putExtra("A2", secondAns)
//                intent.putExtra("A3", thirdAns)
//                intent.putExtra("A4", fourthAns)
//                intent.putExtra("A5", fifthAns)
//
//                val intent = Intent(this, pageThreeSurvey::class.java)
//                startActivity(intent)
//            }
//
//
//
//
//        }
//
//
////        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
////        SharedPreferences.Editor editor = mPreferences.edit();
//
//
//
//
//
//
//
//
//    }
//}