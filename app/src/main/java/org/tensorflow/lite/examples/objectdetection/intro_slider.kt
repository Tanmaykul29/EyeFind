package org.tensorflow.lite.examples.objectdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class intro_slider : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_slider)
        setOnBoardingItem()
    }

    private fun setOnBoardingItem() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
            listOf(
                OnBoardingItem(
                    onboardingImage = R.drawable.obdet1,
                    title = "Step 1",
                    description = "Object Detection and Recongnisation."
                ),
                OnBoardingItem(
                    onboardingImage = R.drawable.obdet2,
                    title = "Step 2",
                    description = "Distance Calculation using mobile sensors"
                ),
                OnBoardingItem(
                    onboardingImage = R.drawable.obdet3,
                    title = "Step 3",
                    description = "Audio output for enhanced experience"
                )
            )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onBoardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter

        findViewById<TextView>(R.id.textSkip).setOnClickListener{
            finish()
        }
        findViewById<Button>(R.id.buttonGetStarted).setOnClickListener {
            finish()
        }

    }

}