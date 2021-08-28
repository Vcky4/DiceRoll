package com.vicksoson.diceroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.dice_button)


        rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()
        val result: ImageView = findViewById(R.id.dice_result)
        val result2: ImageView = findViewById(R.id.dice2_result)

        fun resource(roll: Int): Int {
            return when (roll) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
        }
        result.setImageResource(resource(diceRoll))
        result.contentDescription = diceRoll.toString()
        result2.setImageResource(resource(diceRoll2))
        result2.contentDescription = diceRoll2.toString()
    }

    class Dice(private val sides: Int) {
        fun roll(): Int {
            return (1..sides).random()
        }
    }
}