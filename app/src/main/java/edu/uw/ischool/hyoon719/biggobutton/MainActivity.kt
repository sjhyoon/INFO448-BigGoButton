package edu.uw.ischool.hyoon719.biggobutton

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pushMe = findViewById<Button>(R.id.button)
        pushMe.setBackgroundColor(Color.GREEN)
        pushMe.setTextColor(Color.RED)
        pushMe.setTextSize(40f)
        pushMe.setTypeface(pushMe.typeface, Typeface.ITALIC)

        var count = 0;
        pushMe.setOnClickListener {
            count++
            if (count == 1)
                pushMe.setText("You have pushed me ${count} time!")
            else
                pushMe.setText("You have pushed me ${count} times!")

            pushMe.setBackgroundColor(Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
            pushMe.setTextColor(Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256)))
        }

    }
}