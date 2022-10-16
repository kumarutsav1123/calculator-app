package com.krutsav.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var lastNumeric = false;
    var lastDecimal = false;

    fun onDigit(view:View){
        tvResult.append((view as Button).text)
        tvEquation.append((view as Button).text)
        lastNumeric = true;
    }
    var num1 = 0;
    var num2 = 0;
    fun onOperator(view:View){
//        Toast.makeText(this,"Operator clicked", Toast.LENGTH_SHORT).show()
        num1=(view as Button).text as Int
        tvEquation.append((view as Button).text)
        tvResult.text = ""


    }
    fun onEqual(view:View){
        Toast.makeText(this,"Equal clicked", Toast.LENGTH_SHORT).show()
        tvEquation.append("=")
    }
    fun onClear(view: View){
        tvResult.text = ""
        lastNumeric=false; lastDecimal=false
    }
    fun onClearAll(view: View){
        tvResult.text = ""
        tvEquation.text = ""
        lastNumeric=false; lastDecimal=false
    }
    fun onDecimal(view: View){
        if(lastNumeric == true && lastDecimal == false){
            tvResult.append(".")
            lastDecimal=true
        }
        else if(lastNumeric==false){
            Toast.makeText(this, "Dude, you cannot have decimal without a number", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this, "Dude, when have you put two decimals in one number??", Toast.LENGTH_SHORT).show()
    }
}