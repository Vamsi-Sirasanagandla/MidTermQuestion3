package com.example.midtermquestion3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.View
import android.widget.*
import androidx.core.widget.doOnTextChanged
import com.google.android.material.navigation.NavigationBarView
class App2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app2)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = "Fahrenheit to Celsius"
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("Fahrenheit to Celsius","Fahrenheit to Kelvin","Celsius to Fahrenheit","Celsius to Kelvin","Kelvin to Fahrenheit","Kelvin to Celsius")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            if(flag =="Fahrenheit to Celsius")
                resultTV.text = fahrenheitToCelsius(x).toString()+" C";
            else if(flag == "Fahrenheit to Kelvin")
                resultTV.text = fahrenheitToKelvin(x).toString()+" K";
            else if(flag == "Celsius to Fahrenheit")
                resultTV.text = celsiusToFahrenheit(x).toString()+" F";
            else if(flag == "Celsius to Kelvin")
                resultTV.text = celsiusToKelvin(x).toString()+" K";
            else if(flag == "Kelvin to Fahrenheit")
                resultTV.text = kelvinToFahrenheit(x).toString()+" F";
            else if(flag == "Kelvin to Celsius")
                resultTV.text = kelvinToCelsius(x).toString()+" C";
            else
                resultTV.text = "Invalid Selection";
        }
        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("No implementation")
            }
        }
    }
}
public fun fahrenheitToCelsius(a: Int): Double {
    val ans= (a-32)/1.8
    return String.format("%.2f", ans).toDouble()
}
public fun fahrenheitToKelvin(a: Int): Double{
    val ans= ((a-32)/1.8)+273
    return String.format("%.2f", ans).toDouble()
}
public fun celsiusToFahrenheit(a: Int): Double {
    val ans= (a*1.8+32)
    return String.format("%.2f", ans).toDouble()
}
public fun celsiusToKelvin(a: Int): Int{
    val ans= a+273
    return ans
}
public fun kelvinToFahrenheit(a: Int): Double{
    val ans= ((a-273)-32)/1.8
    return String.format("%.2f", ans).toDouble()
}
public fun kelvinToCelsius(a: Int): Int {
    val ans= a-273
    return ans
}