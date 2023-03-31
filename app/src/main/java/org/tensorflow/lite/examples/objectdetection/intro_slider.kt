package org.tensorflow.lite.examples.objectdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class intro_slider : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorsConatiner: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_slider)
        setOnBoardingItem()
        setupIndicators()
        setCurrentIndicator(0)
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

        onboardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int){
                    super.onPageSelected(position)
                    setCurrentIndicator(position)
                }
            })
            (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
                RecyclerView.OVER_SCROLL_NEVER
            findViewById<ImageView>(R.id.imageNext).setOnClickListener {
                if(onboardingViewPager.currentItem+1 < onboardingItemsAdapter.itemCount){
                    onboardingViewPager.currentItem+=1
                }
                else{
                    finish()
                }
            }


        findViewById<TextView>(R.id.textSkip).setOnClickListener{
            finish()
        }
        findViewById<Button>(R.id.buttonGetStarted).setOnClickListener {
            finish()
        }
    }

    private fun setupIndicators(){
        indicatorsConatiner = findViewById(R.id.indicatorsConatiner)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)
        for(i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
                it.layoutParams = layoutParams
                indicatorsConatiner.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int){
        val childCount = indicatorsConatiner.childCount
        for(i in 0 until childCount){
            val imageView = indicatorsConatiner.getChildAt(i) as ImageView
            if(i == position){
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active_background
                    )
                )
            }
            else{
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive_background
                    )
                )
            }
        }
    }

}