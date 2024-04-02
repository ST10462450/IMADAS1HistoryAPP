package com.example.assignment1historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {
    //declaring the global variables
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var infoTextView: TextView
    private lateinit var ageInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //reference the buttons and Text boxes etc
        ageInput = findViewById(R.id.ageInput)
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        infoTextView = findViewById(R.id.infoTextView)

        searchButton?.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()
            if ((age != null) && (age < 100) && (age > 35)) {
                val historyInfo = when (age) {
                    36 -> {
                        "You are 36 years old, which is the same age that Bob Marley died, he was a very famous Reggae artist"
                    }

                    40 -> {
                        "You are 40 years old, which is the same age that Paul walker died, he was one of the main actors in world famous movie series fast and furious"
                    }

                    48 -> {
                        "You are 48 years old, which is the same age that Whitney Houston died , she was a very famous R&B singer who is still popular today"
                    }

                    54 -> {
                        "You are 54 years old, which is the same age that Christopher Columbus died, he was a voyager who claimed the East Indies"
                    }

                    59 -> {
                        "You are 59 years old, which is the same age that Coolio died, he was a famous american rapper"
                    }

                    62 -> {
                        "You are 62 years old, which is the same age that Toby Keith died, he was a famous country singer"
                    }

                    67 -> {
                        "You are 67 years old, which is the same age that George Washington died, he was one of the founding fathers of the united states "
                    }

                    78 -> {
                        "You are 78 years old, which is the same age that Mahatma Gandhi died, he was a revolutionary leader for India"
                    }

                    84 -> {
                        "You are 84 years old, which is the same age that Isaac Newton died, he invented the 3 basic laws of motion"
                    }

                    88 -> {
                        "You are 88 years old, which is the same age that Bill Russell, he was one of the greatest basketball players of all time"
                    }

                    else -> {
                        null
                    }
                }

                val message = if (historyInfo != null) " $historyInfo "
                else "No historical figure recorded dead at that age"
                infoTextView.text = message

            } else {
                infoTextView.text = "please input an age between 35 and 100"}
            run {
                clearButton?.setOnClickListener {
                    ageInput.text.clear()
                    infoTextView.text = ""


                }


            }
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}