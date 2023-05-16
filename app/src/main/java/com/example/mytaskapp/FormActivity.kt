package com.example.mytaskapp

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mytaskapp.databinding.ActivityFormBinding

class FormActivity:AppCompatActivity() {

    lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val input = intent.getStringExtra("KEY")

        val first=input?.first().toString()
        if (first=="T"){
            applytextView(input.toString())
            val label=first.substringAfter('~')
            Toast.makeText(this,"${label}",Toast.LENGTH_SHORT).show()
            val min=label.substringAfter('~')
            Toast.makeText(this,"${min}",Toast.LENGTH_SHORT).show()
            val max=min.substringAfter('~')
            Toast.makeText(this,"${max}",Toast.LENGTH_SHORT).show()

        }


        fun getSub(dl:Char): Array<String> {
            var word = input.toString()
            var str=""
            val num = 0
            str = str + dl
            val l= str.length
            var substr_list:Array<String> = arrayOf()
            for (i in 0 until l) {
                word = if (str[i] !== dl) {
                    word + str[i]
                } else {

                    if (word.length != 0) {
                        substr_list.plus(word)
                    }
                    ""
                }
            }
            return substr_list
        }


    }
   private fun applytextView(data:String){
       val input = intent.getStringExtra("KEY")
       if (input?.contains('|') == true){
            val part= input.toString()
            val seg:Array<String> = arrayOf(part.substring(part.lastIndexOf("/") + 1))
            var textlayout= LinearLayout(this)
            textlayout.orientation= LinearLayout.HORIZONTAL
            binding.linearLayout.addView(textlayout)
            var textView= TextView(this)
            textView.setText("")
            setTextView(seg as TextView)
            textlayout.addView(textView)
        }
    }

    private fun setTextView(textView: TextView){
        val params=LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        textView.setTextColor(Color.CYAN)
        textView.textSize=16f
        textView.layoutParams=params
    }
}