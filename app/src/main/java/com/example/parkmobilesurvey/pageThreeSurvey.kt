package com.example.parkmobilesurvey

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class pageThreeSurvey : AppCompatActivity() {
    private lateinit var test : TextView
    private lateinit var editText : EditText
    private lateinit var submit: Button


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
        val sixthAns = intent1.getStringExtra("A6")
        val seventhAns = intent1.getStringExtra("A7")
        val eighthAns = intent1.getStringExtra("A8") //from previous activity



        editText = findViewById(R.id.editText)
        submit = findViewById(R.id.button2)

        submit.setOnClickListener {

            val ninthAnswer: String = editText.text.toString()
            val db = FirebaseDatabase.getInstance();
            val ref = db.getReference("survey submission")
            val answers = "Park name: " + parkName +
                    ", Cleanliness of park: " + firstAns +
                    ", Safety of park: " + secondAns +
                    ", Friendliness of park staff: " + thirdAns +
                    ", Accessibility of drinking fountains: " + fourthAns +
                    ", Recommendation of park to friend: "+ sixthAns +
                    ", Enjoyability of stay: " + fifthAns +
                    ", Please rate us: " + seventhAns +
                    ", Planned activities happened as expected: " + eighthAns +
                    ", Additional recommendations: " + ninthAnswer
            val surveyId = ref.push().key
            if (surveyId != null) {
                ref.child(surveyId).setValue(answers)
            }
            Toast.makeText(this, "Survey answers submitted", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }



    }
}