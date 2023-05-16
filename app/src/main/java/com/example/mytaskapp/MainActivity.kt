package com.example.mytaskapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.mytaskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNext.setOnClickListener {
            //if (inputCheck(binding.edtTxt)){
                var intent=Intent(this,GenericViewActivity::class.java)
                intent.putExtra("KEY",binding.edtTxt.text.toString()!!)
                startActivity(intent)
            }
        //}
    }
//    fun inputCheck(editText: EditText):Boolean{
//        if (editText.text.contains('~')){
//            return true
//        }
//        return false
//    }
}
