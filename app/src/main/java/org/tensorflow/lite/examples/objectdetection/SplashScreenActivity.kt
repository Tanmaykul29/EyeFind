package org.tensorflow.lite.examples.objectdetection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.widget.ImageView
import android.view.animation.AnimationUtils
import androidx.constraintlayout.motion.widget.MotionLayout

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)
        motionLayout.addTransitionListener(object: MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {

            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {

            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {

            }

        })

//        val backgroundImg : ImageView = findViewById(R.id.iv_logo)
//        val sideAnimation = AnimationUtils.loadAnimation(this,R.anim.slide)
//        backgroundImg.startAnimation(sideAnimation)
//        Handler().postDelayed({
//            startActivity(Intent(this,MainActivity::class.java))
//            finish()
//        },3000)

    }
}