package com.st10446781.assignment2part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var petImageView: ImageView
    private lateinit var healthProgressBar: ProgressBar
    private lateinit var hungerProgressBar: ProgressBar
    private lateinit var cleanlinessProgressBar: ProgressBar
    private lateinit var healthTextView: TextView
    private lateinit var hungerTextView: TextView
    private lateinit var cleanlinessTextView: TextView

    private var health = 0
    private var hunger = 0
    private var cleanliness = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        }

        private fun setupPetCareScreen() {
            petImageView = findViewById(R.id.imageView)
            healthProgressBar = findViewById(R.id.progressBar)
            hungerProgressBar = findViewById(R.id.progressBar2)
            cleanlinessProgressBar = findViewById(R.id.progressBar3)
            healthTextView = findViewById(R.id.textView)
            hungerTextView = findViewById(R.id.textView2)
            cleanlinessTextView = findViewById(R.id.textView3)

            // Initialize progress bars to 0
            healthProgressBar.progress = 0
            hungerProgressBar.progress = 0
            cleanlinessProgressBar.progress = 0

            val feedButton: Button = findViewById(R.id.button)
            val cleanButton: Button = findViewById(R.id.button2)
            val playButton: Button = findViewById(R.id.button3)

            feedButton.setOnClickListener {
                petImageView.setBackgroundResource(R.drawable.dogfeed)
                updatePetStatus("feed")
            }

            cleanButton.setOnClickListener {
                petImageView.setBackgroundResource(R.drawable.dogbath)
                updatePetStatus("clean")
            }

            playButton.setOnClickListener {
                petImageView.setBackgroundResource(R.drawable.dogplay)
                updatePetStatus("play")
            }
        }

        private fun updatePetStatus(action: String) {
            when (action) {
                "feed" -> {
                    hunger += 5
                    if (hunger > 100) hunger = 100
                }

                "clean" -> {
                    cleanliness += 5
                    if (cleanliness > 100) cleanliness = 100
                }

                "play" -> {
                    health += 5
                    if (health > 100) health = 100
                }
            }
            // Update progress bars
            updateProgressBars()
        }

        private fun updateProgressBars() {
            // Update progress bars based on current values
            healthProgressBar.progress = health
            hungerProgressBar.progress = hunger
            cleanlinessProgressBar.progress = cleanliness

            // Update TextViews next to progress bars
            healthTextView.text = "$health%"
            hungerTextView.text = "$hunger%"
            cleanlinessTextView.text = "$cleanliness%"
        }
    }

