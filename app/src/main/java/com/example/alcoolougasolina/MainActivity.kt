package com.example.alcoolougasolina


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var percentual:Double = 0.7
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("PDM23","No onCreate, $percentual")

        val switchButton: Switch = findViewById(R.id.swPercentual)
        val prefs = getSharedPreferences("MY_APP", MODE_PRIVATE)

        switchButton.isChecked = prefs.getBoolean("SWITCH_STATE", false)

        switchButton.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("SWITCH_STATE", isChecked).apply()
        }

        val btCalc: Button = findViewById(R.id.btCalcular)
        btCalc.setOnClickListener(View.OnClickListener {
            //código do evento

            val etAlcool: EditText = findViewById(R.id.edAlcool)
            val etGasolina: EditText = findViewById(R.id.edGasolina)

            val valorAlcool = etAlcool.text.toString().toDouble()
            val valorGasolina = etGasolina.text.toString().toDouble()

            val switchStatus: Boolean = switchButton.isChecked()

            val resultado: TextView = findViewById(R.id.resultado)

            if(switchStatus) {
                percentual = 0.75
            } else {
                percentual = 0.7
            }

            var calc:Double = valorGasolina * percentual
            Log.d("PDM23","calculo, $valorAlcool, $calc")

            if(valorAlcool > calc) {
                resultado.setText("Gasolina é mais rentável")
            } else if(valorAlcool < calc) {
                resultado.setText("Álcool é mais rentável")
            }
            else{
                resultado.setText("Álcool é mais rentável")
            }

            Log.d("PDM23","Valor Alcool, $valorAlcool")
            Log.d("PDM23","Valor Gasolina, $valorGasolina")
            Log.d("PDM23","switch, $switchStatus")


            Log.d("PDM23","No btCalcular, $percentual")
        })

    }
    override fun onResume(){
        super.onResume()
        Log.d("PDM23","No onResume, $percentual")
    }
    override fun onStart(){
        super.onStart()
        Log.d("PDM23","No onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.d("PDM23","No onResume")
    }
    override fun onStop(){
        super.onStop()
        Log.d("PDM23","No onResume")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d("PDM23","No onResume")
    }
}