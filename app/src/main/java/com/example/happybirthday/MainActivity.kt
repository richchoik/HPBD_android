package com.example.happybirthday

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity(), View.OnClickListener {

    lateinit var displayResult: TextView

    var currentState: Int = 1 // Trạng thái: 1 = nhập số đầu tiên, 2 = nhập số thứ hai
    var operator: Int = 0 // 1: cộng, 2: trừ, 3: nhân, 4: chia
    var operand1: Int = 0
    var operand2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayResult = findViewById(R.id.display_result)

        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)
        findViewById<Button>(R.id.buttonAdd).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSub).setOnClickListener(this)
        findViewById<Button>(R.id.buttonMul).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDiv).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEqual).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val buttonId = view?.id
        when (buttonId) {
            R.id.button0 -> updateNumber(0)
            R.id.button1 -> updateNumber(1)
            R.id.button2 -> updateNumber(2)
            R.id.button3 -> updateNumber(3)
            R.id.button4 -> updateNumber(4)
            R.id.button5 -> updateNumber(5)
            R.id.button6 -> updateNumber(6)
            R.id.button7 -> updateNumber(7)
            R.id.button8 -> updateNumber(8)
            R.id.button9 -> updateNumber(9)
            R.id.buttonAdd -> {
                operator = 1  // Cộng
                currentState = 2
            }
            R.id.buttonSub -> {
                operator = 2  // Trừ
                currentState = 2
            }
            R.id.buttonMul -> {
                operator = 3  // Nhân
                currentState = 2
            }
            R.id.buttonDiv -> {
                operator = 4  // Chia
                currentState = 2
            }
            R.id.buttonEqual -> {
                val result = when (operator) {
                    1 -> operand1 + operand2  // Cộng
                    2 -> operand1 - operand2  // Trừ
                    3 -> operand1 * operand2  // Nhân
                    4 -> if (operand2 != 0) operand1 / operand2 else 0 // Chia (tránh chia cho 0)
                    else -> 0
                }
                displayResult.text = "$result"
                resetCalculator()
            }
        }
    }

    private fun updateNumber(number: Int) {
        if (currentState == 1) {
            operand1 = operand1 * 10 + number
            displayResult.text = "$operand1"
        } else {
            operand2 = operand2 * 10 + number
            displayResult.text = "$operand2"
        }
    }

    private fun resetCalculator() {
        currentState = 1
        operand1 = 0
        operand2 = 0
        operator = 0
    }
}
