package com.izelhatipoglu.zaratma


import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dice_rolling.visibility = View.GONE

        button.setOnClickListener {
            dice_rolling.visibility = View.VISIBLE
            dice_rolling.setAnimation("rolling.json")
            dice_rolling.playAnimation()
            diceView.visibility = View.GONE
                    object :CountDownTimer(3000,1000){
                        override fun onTick(millisUntilFinished: Long) {
                            textTime.text="Time: "+millisUntilFinished/1000
                            
                        }

                        override fun onFinish() {
                            textTime.text="Time: 0"
                            dice_rolling.cancelAnimation()
                            dice_rolling.visibility = View.GONE
                            diceView.visibility = View.VISIBLE
                            rollDice()



                        }

                    }.start()

        }

    }


    private fun rollDice(){
        val randomNumber= (1..6).random()
        textView.text= "${randomNumber} rolled"

        when (randomNumber){
            1->diceView.setImageResource(R.drawable.dice1)
            2->diceView.setImageResource(R.drawable.dice2)
            3->diceView.setImageResource(R.drawable.dice3)
            4->diceView.setImageResource(R.drawable.dice4)
            5->diceView.setImageResource(R.drawable.dice5)
            6->diceView.setImageResource(R.drawable.dice6)
        }
    }



}

