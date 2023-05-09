package org.tensorflow.lite.examples.objectdetection

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import org.tensorflow.lite.examples.objectdetection.MainActivity

class EntryPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_page)

        val txtButton : Button = findViewById(R.id.txt_recog_button)
        txtButton.setOnClickListener {
            returnResult(Activity.RESULT_OK)
        }
        val objButton:Button=findViewById(R.id.obj_recog_button)
        objButton.setOnClickListener {
            returnResult(Activity.RESULT_CANCELED)
        }

    }
    private fun returnResult(resultCode: Int) {
        val resultIntent = Intent()
        setResult(resultCode, resultIntent)
        finish()
    }


}