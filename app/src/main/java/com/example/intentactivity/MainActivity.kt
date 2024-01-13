package com.example.intentactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val textToPass = editText.text.toString()
            Intent(this, SecondActivity::class.java).also {
                it.putExtra("textToDisplay", textToPass)
                startActivity(it)
            }
        }

        val dialButton = findViewById<Button>(R.id.dialButton)

        dialButton.setOnClickListener {
            val phoneNumber = findViewById<EditText>(R.id.editTextPhone).text.toString()
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
    }
}