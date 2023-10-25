package com.example.register_noconstraint

import android.widget.Toast
import android.content.Context
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstname : TextInputLayout = findViewById(R.id.firstname)
        val lastname : TextInputLayout = findViewById(R.id.lastname)
        val radio1 : RadioButton = findViewById(R.id.Gender)
        val selectradio1 = radio1.isChecked
        val radio2 : RadioButton = findViewById(R.id.Male)
        val selectradio2 = radio2.isChecked
        val radio3 : RadioButton = findViewById(R.id.Female)
        val selectradio3 = radio3.isChecked
        val birthday : TextInputLayout = findViewById(R.id.birthday)
        val address : TextInputLayout = findViewById(R.id.address)
        val email : TextInputLayout = findViewById(R.id.email)
        val checkbox : CheckBox = findViewById(R.id.checkBox)
        val selectcheckbox = checkbox.isChecked
        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            val all =check(firstname.editText?.text.toString(),
                lastname.editText?.text.toString(),
                selectradio1,
                selectradio2,
                selectradio3,
                birthday.editText?.text.toString(),
                address.editText?.text.toString(),
                email.editText?.text.toString(),
                selectcheckbox)
            val context : Context = applicationContext
            val text1 = "Đăng kí thành công"
            val text2 = "Đăng kí thất bại do nhập thiếu thông tin"
            val duration = Toast.LENGTH_SHORT
            if(all){
                val toast = Toast.makeText(context,text1,duration)
                toast.show()
            }else{
                val toast = Toast.makeText(context,text2,duration)
                toast.show()
            }

        }

    }
    private fun check(
        firstname: String,
        lastname: String,
        seclectradio1: Boolean,
        selectradio2: Boolean,
        selectradio3: Boolean,
        birthday: String,
        address: String,
        email: String,
        selectcheckbox: Boolean):Boolean{
        val s = listOf(firstname, lastname, seclectradio1, selectradio2, selectradio3, birthday, address, email, selectcheckbox)
        return s.all { true }
    }
}