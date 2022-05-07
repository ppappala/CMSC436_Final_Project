package com.example.parkmobilesurvey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.parkmobilesurvey.ui.main.MainFragment
import com.example.surverypart2.SurveyPage2

class MainActivity : AppCompatActivity() {

    private lateinit var next1: Button // will change after stephane put's files in

    override fun onCreate(savedInstanceState: Bundle?) {
        // This will be a filler for the first survey page
        // until Stephane put's his files in

        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        next1 = findViewById(R.id.next1)

        // To go to second survey page (third page of app)
        next1.setOnClickListener {
            val intent = Intent(this, SurveyPage2::class.java)
            startActivity(intent);
        }



//        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
        // Pranav was here
        // Keya was here
        // Pranav was here again
        // stephane was here
    }
}