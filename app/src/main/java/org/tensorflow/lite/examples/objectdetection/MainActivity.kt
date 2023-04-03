/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import org.tensorflow.lite.examples.objectdetection.databinding.ActivityMainBinding
import java.util.*

/**
 * Main entry point into our app. This app follows the single-activity pattern, and all
 * functionality is implemented in the form of fragments.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private var tts: TextToSpeech?= null
    private var btn: Button?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigatetointro_slider()
        navigate_to_object_detection()
//        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(activityMainBinding.root)
    }

    private fun navigate_to_object_detection(){
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
    //
    private fun navigatetointro_slider(){
        startActivity(Intent(applicationContext, intro_slider::class.java))
    }

    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
}

class TextToSpeechHelper {
    companion object {
        private var tts: TextToSpeech ?= null
        fun speak(context: Context, text: String) {

            tts = TextToSpeech(context, TextToSpeech.OnInitListener { status ->
                //tts = TextToSpeech(context,TextToSpeech.OnInitListener{})
                if (status == TextToSpeech.SUCCESS) {
                    val result = tts!!.setLanguage(Locale.US)
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Toast.makeText(context, "Language not supported", Toast.LENGTH_SHORT).show()
                    } else {
                        //Toast.makeText(context, "Hey $text", Toast.LENGTH_SHORT).show()
                        tts!!.setSpeechRate(1.5f)
                        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
                        //Thread.sleep(1000)
                    }
                } else {
                    Toast.makeText(context, "Initialization failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}