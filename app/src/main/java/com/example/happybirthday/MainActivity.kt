package com.example.happybirthday

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG: String = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        val logButton: Button = findViewById(R.id.logButton)
        val diceImage: ImageView = findViewById(R.id.diceView)
        diceImage.setImageResource(R.drawable.dice_1)
        //var rollButtonString: String = getString(R.string.button_roll)
        logButton.setOnClickListener {
            logging()
        }

        rollButton.setOnClickListener {
            Toast.makeText(
                this,
                "Your Order has been marked as complete / cancelled. ",
                Toast.LENGTH_LONG
            ).show()
            rollDice()
            //throw RuntimeException("Test Crash") // Force a crash
//var z: Int = 2 / 0
        }
    }

    private fun logging() {
        val numerator = 60
        var denominator = 4
        repeat (5) {
            Log.v(TAG, "it is: ${it}")
            Log.v(TAG, "Denominator: ${denominator}")
            Log.v(TAG, "${numerator/denominator}")
            denominator--

        }
        Log.v(TAG, "My Hello Log Message")
    }

    private fun rollDice() {
        val myDice = Dice(6)
        val myDice2 = Dice(6)
        val dice1Image: ImageView = findViewById(R.id.diceView)
        //val dice2Image: ImageView = findViewById(R.id.diceView)

        val resultTextView: TextView = findViewById(R.id.textView)
        val intDice1 = myDice.roll()
        resultTextView.text = intDice1.toString()
        val drawableResource = when (intDice1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> { R.drawable.dice_1}
        }
        dice1Image.setImageResource(drawableResource)

        val intDice2 = myDice2.roll()
        findViewById<TextView>(R.id.textView2).text = intDice2.toString()
    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}