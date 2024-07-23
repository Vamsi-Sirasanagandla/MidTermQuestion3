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
class App1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app1)
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg = bundle.getString("key")
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
        }
        val button: Button = findViewById(R.id.btResult)
        val edtxt1: EditText = findViewById(R.id.ednum1)
        val edtxt2: EditText = findViewById(R.id.ednum2)
        val resultTV: TextView = findViewById(R.id.textResult)
        var flag : String = "sum"
        val spinnerVal : Spinner = findViewById(R.id.spSelect)
        var options = arrayOf("sum","difference","multiply","division")
        spinnerVal.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options )
        button.setOnClickListener{ view ->
            var x: Int = edtxt1.text.toString().toInt();
            var y: Int = edtxt2.text.toString().toInt();
            when(flag =="sum") {
                true ->resultTV.text = sum(x, y).toString();
                else->when(flag == "difference"){
                    true -> resultTV.text= sub(x,y).toString();
                    else->when(flag=="multiply"){
                        true -> resultTV.text = multiply(x,y).toString();
                        false -> resultTV.text = division(x,y).toString();
                    }
                }
            }
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
public fun sum(a: Int, b: Int): Int {
    return a+b
}
public fun sub(a: Int, b: Int): Int {
    return a-b;
}
public fun multiply(a: Int, b: Int): Int {
    return a*b;
}
public fun division(a: Int, b:Int): Int {
    return a/b;
}
