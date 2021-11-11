package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        //將變數與XML元件綁定
        val btn_send = findViewById<Button>(R.id.btn_send)
        val drink = findViewById<EditText>(R.id.drink)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)

        btn_send.setOnClickListener{
            if(drink.length()<1)
                Toast.makeText(this,"請輸入飲料名稱",Toast.LENGTH_SHORT).show()
            else {
                //宣告Bundle
                val b = Bundle()
                //取得EditText字串內容，把飲料名稱、甜度與冰塊資訊放入Bundle
                b.putString("drink",drink.text.toString())
                b.putString("sugar",radioGroup.findViewById<RadioButton>
                    (radioGroup.checkedRadioButtonId).text.toString())
                b.putString("ice",radioGroup1.findViewById<RadioButton>
                    (radioGroup1.checkedRadioButtonId).text.toString())
                //用Activity.RESULT_OK標記執行狀態並記錄Intent
                setResult(Activity.RESULT_OK, Intent().putExtras(b))
                finish()
            }
        }
    }
}