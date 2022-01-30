package com.example.myfirtsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progessText = findViewById<TextView>(R.id.txtProgess)
        val resetButton = findViewById<Button>(R.id.btnReset)
        val seekBar     = findViewById<SeekBar>(R.id.seekBar)

        val initialPostion = progessText.translationY

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                progessText.text = progress.toString()
                progessText.animate().translationY(initialPostion+(progress * 50).toFloat() * -1)

                if(!fromUser)
                    progessText.animate().setDuration(500).rotationBy(360f).translationY( initialPostion)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                //println("Touching")

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                progessText.animate().setDuration(500).rotationBy(360f)

                //println("not Touching")
            }

        })
        resetButton.setOnClickListener{
            seekBar.progress = 0
        }
    }
}