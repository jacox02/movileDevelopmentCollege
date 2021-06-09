package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var firstNumbers = 0.0;
    private var secondNumbers = 0.0;
    private var operation = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNumber0 = findViewById<Button>(R.id.ceroBtn)
        val btnNumber1 = findViewById<Button>(R.id.oneBtn)
        val btnNumber2 = findViewById<Button>(R.id.twoBtn)
        val btnNumber3 = findViewById<Button>(R.id.treeBtn)
        val btnNumber4 = findViewById<Button>(R.id.fourBtn)
        val btnNumber5 = findViewById<Button>(R.id.fiveBtn)
        val btnNumber6 = findViewById<Button>(R.id.sixBtn)
        val btnNumber7 = findViewById<Button>(R.id.sevenBtn)
        val btnNumber8 = findViewById<Button>(R.id.eightBtn)
        val btnNumber9 = findViewById<Button>(R.id.nineBtn)

        val btnClear=findViewById<Button>(R.id.clearBtn);
        val btnDelete= findViewById<Button>(R.id.deleteBtn);

        val btnAdd= findViewById<Button>(R.id.addBtn);
        val btnMultiply = findViewById<Button>(R.id.multiplyBtn);
        val btnDivide = findViewById<Button>(R.id.divideBtn);
        val btnSubstract = findViewById<Button>(R.id.substractBtn);
        val btnCalculate = findViewById<Button>(R.id.equalsBtn);
        val btnNumberCalculateOnDOP = findViewById<Button>(R.id.calculateDOPBtn)
        val btnNumberCalculateOnUSD = findViewById<Button>(R.id.calculateUSDBtn)

        val txt_operationAndResponse = findViewById<TextView>(R.id.operationAndResult)

        btnDelete.setOnClickListener({
            firstNumbers = 0.0;
            secondNumbers = 0.0;
        txt_operationAndResponse.text = "0";
            operation = NOOP;
        })
        btnCalculate.setOnClickListener({
          var result =  when(operation){
              SUMA -> firstNumbers + secondNumbers
              RESTA -> firstNumbers - secondNumbers
              MULTIPLICACION -> firstNumbers * secondNumbers
              DIVISION -> firstNumbers / secondNumbers
              else -> 0
          }


        })
        btnAdd.setOnClickListener( {HandleOperation(SUMA)})
        btnMultiply.setOnClickListener( {HandleOperation(MULTIPLICACION)})
        btnDivide.setOnClickListener( {HandleOperation(DIVISION)})
        btnSubstract.setOnClickListener( {HandleOperation(RESTA)})

        btnNumber0.setOnClickListener(View.OnClickListener { HandleNumber("0") })
        btnNumber1.setOnClickListener(View.OnClickListener { HandleNumber("1") })
        btnNumber2.setOnClickListener(View.OnClickListener { HandleNumber("2") })
        btnNumber3.setOnClickListener(View.OnClickListener { HandleNumber("3") })
        btnNumber4.setOnClickListener(View.OnClickListener { HandleNumber("4") })
        btnNumber5.setOnClickListener(View.OnClickListener { HandleNumber("5") })
        btnNumber6.setOnClickListener(View.OnClickListener { HandleNumber("6") })
        btnNumber7.setOnClickListener(View.OnClickListener { HandleNumber("7") })
        btnNumber8.setOnClickListener(View.OnClickListener { HandleNumber("8") })
        btnNumber9.setOnClickListener(View.OnClickListener { HandleNumber("9") })


    }

    private fun HandleNumber(numeroPresionado: String) {
        val txt_operationAndResponse = findViewById<TextView>(R.id.operationAndResult)
        txt_operationAndResponse.text = "${txt_operationAndResponse.text}$numeroPresionado";
    }

    private fun HandleOperation(operacion :  Int) {
        val txt_operationAndResponse = findViewById<TextView>(R.id.operationAndResult)
        this.operation = operacion;
        firstNumbers = txt_operationAndResponse.text.toString().toDouble();
        txt_operationAndResponse.text = "0";
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NOOP = 0
    }

}