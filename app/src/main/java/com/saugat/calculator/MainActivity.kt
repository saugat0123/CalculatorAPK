package com.saugat.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var etscreen: EditText
    private lateinit var btn0: Button
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btnpoint: Button
    private lateinit var btnplus: Button
    private lateinit var btnminus: Button
    private lateinit var btnmultiply: Button
    private lateinit var btndivide: Button
    private lateinit var btnclear: Button
    private lateinit var btnequals: Button
    private lateinit var btnpercent: Button

    var removeZero = true
    var oldNum = ""
    var operatorr = "+"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         etscreen= findViewById(R.id.etscreen)
         btn0= findViewById(R.id.btn0)
        btn1= findViewById(R.id.btn1)
        btn2= findViewById(R.id.btn2)
        btn3= findViewById(R.id.btn3)
        btn4= findViewById(R.id.btn4)
        btn5= findViewById(R.id.btn5)
        btn6= findViewById(R.id.btn6)
        btn7= findViewById(R.id.btn7)
        btn8= findViewById(R.id.btn8)
        btn9= findViewById(R.id.btn9)
        btnpoint= findViewById(R.id.btnpoint)
        btnplus= findViewById(R.id.btnplus)
        btnminus= findViewById(R.id.btnminus)
        btnmultiply= findViewById(R.id.btnmultiply)
        btndivide= findViewById(R.id.btndivide)
        btnclear= findViewById(R.id.btnclear)
        btnequals= findViewById(R.id.btnequals)
        btnpercent= findViewById(R.id.btnpercent)

    }

    fun numEvent(view: View) {
        try {
            if (removeZero)
                etscreen.setText("")
            removeZero = false
            var btnClick = etscreen.text.toString()
            var btnSelect = view as Button
            when (btnSelect.id) {
                btn1.id -> {
                    btnClick += "1"
                }
                btn2.id -> {
                    btnClick += "2"
                }
                btn3.id -> {
                    btnClick += "3"
                }
                btn4.id -> {
                    btnClick += "4"
                }
                btn5.id -> {
                    btnClick += "5"
                }
                btn6.id -> {
                    btnClick += "6"
                }
                btn7.id -> {
                    btnClick += "7"
                }
                btn8.id -> {
                    btnClick += "8"
                }
                btn9.id -> {
                    btnClick += "9"
                }
                btn0.id -> {
                    btnClick += "0"
                }
                btnpoint.id -> {
                    btnClick += "."
                }
            }
            etscreen.setText(btnClick)
        }
        catch (ex:Exception){
            Toast.makeText(this, ex.message, Toast.LENGTH_SHORT).show()
        }
    }

    fun clsEvent(view: View) {
        etscreen.setText("0")
        removeZero = true
    }

    fun operatorEvent(view: View) {
        removeZero = true
        oldNum = etscreen.text.toString()
        var btnSelect = view as Button
        when(btnSelect.id){
            btnplus.id -> {operatorr = "+"}
            btnminus.id -> {operatorr = "-"}
            btnmultiply.id -> {operatorr = "*"}
            btndivide.id -> {operatorr = "/"}
        }
    }

    fun equalEvent(view: View) {
        var newNum = etscreen.text.toString()
        var result = 0.0
        when (operatorr){
            "+" -> {result = oldNum.toDouble() + newNum.toDouble()}
            "-" -> {result = oldNum.toDouble() - newNum.toDouble()}
            "*" -> {result = oldNum.toDouble() * newNum.toDouble()}
            "/" -> {result = oldNum.toDouble() / newNum.toDouble()}
        }
        etscreen.setText(result.toString())
        removeZero = true
    }

    fun percentEvent(view: View) {
        var num = etscreen.text.toString().toDouble()/100
        etscreen.setText(num.toString())
        removeZero = true
    }
}