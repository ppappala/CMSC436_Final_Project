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

    // added back radiogroup 5 and button


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_two_survey)

        next2 = findViewById(R.id.next2)
        group3 = findViewById(R.id.radioGroup3)
        group4 = findViewById(R.id.radioGroup4)
        group5 = findViewById(R.id.radioGroup5)



        next2.setOnClickListener {

            val check3: Int = group3.checkedRadioButtonId

            //the checked radio button for fourth quesiton

            val check4: Int = group4.checkedRadioButtonId

            //the checked radio button for fifth quesiton

            val check5: Int = group5.checkedRadioButtonId //uncommented




            val intent2 = intent

            if(check3 < 0 || check4 < 0 ){
                Toast.makeText(this, "You must answer all the questions", Toast.LENGTH_SHORT).show()

            }else {
                radio3 = findViewById(check3)
                radio4 = findViewById(check4)
                radio5 = findViewById(check5) //

                val thirdAns = radio3.text
                val fourthAns = radio4.text
                val fifthAns = radio5.text //
                val parkName = intent2.getStringExtra("park")
                val firstAns = intent2.getStringExtra("A1")
                val secondAns = intent2.getStringExtra("A2")

                val intent1 = Intent(this, pageThreeSurvey::class.java)

                intent1.putExtra("park", parkName)
                intent1.putExtra("A1", firstAns)
                intent1.putExtra("A2", secondAns)
                intent1.putExtra("A3", thirdAns)
                intent1.putExtra("A4", fourthAns)
                intent1.putExtra("A5", fifthAns) // uncommented
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