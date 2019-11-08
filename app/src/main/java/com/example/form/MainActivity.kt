package com.example.form
//按確認送出按鈕後,選擇對話會持續存在
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var msg:TextView
    lateinit var submit:Button
    var order:String? = ""
    var time:String? = ""
    var after:String? = "睡覺"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinner = findViewById(R.id.spinner)
        msg = findViewById(R.id.message)
        submit = findViewById(R.id.btnSubmit)
        var adapter:ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.fruits,
            R.layout.support_simple_spinner_dropdown_item)
        spinner.adapter = adapter
//清單spinner下拉選項
        spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                var item:Any = parent!!.getItemAtPosition(position)
//差別:非短暫顯示
                time = "您選擇的吃東西時間為: $item \n"
            }
        }
//圓-二選一-點選紐
        var ra_group:RadioGroup = findViewById(R.id.is_spicy)
//核取方塊
        var food1:CheckBox = findViewById(R.id.checkBox)
        var food2:CheckBox = findViewById(R.id.checkBox2)
        var food3:CheckBox = findViewById(R.id.checkBox3)

        ra_group.setOnCheckedChangeListener { group, checkedId ->
            var radio:RadioButton = findViewById(checkedId)
            after = radio.text.toString() +"\n"
        }


        food1.setOnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked)
              order = order + food1.text.toString() +"\n"
            //實驗,沒else也沒關係
            //else
              //order = order?.replace(food1.text.toString(),"")
        }
        food2.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
                order = order + food2.text.toString() +"\n"
            //else
               // order = order?.replace(food2.text.toString(),"")
        }
        food3.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
                order = order + food3.text.toString() +"\n"
           // else
                //order = order?.replace(food3.text.toString(),"")
        }
        btnSubmit.setOnClickListener {
            msg.setText(time+order?.trimMargin()+" ,然後吃完就:$after")
        }
    }

}
