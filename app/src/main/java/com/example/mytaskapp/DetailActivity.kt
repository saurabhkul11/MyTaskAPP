package com.example.mytaskapp

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mytaskapp.databinding.ActivityGenericBinding

class DetailActivity:AppCompatActivity() {


    lateinit var binding : ActivityGenericBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGenericBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input = intent.getStringExtra("KEY").toString()
        val res=input?.first().toString()
        val data=input?.substringAfter('~')

        val delemiters1="$"
        val delemiters2="~"
        val spilt=input.split( delemiters1,delemiters2,ignoreCase = false)

        Log.d("data",spilt.toString())


        val arr=data as Array<String>

        for(i in 0 ..arr.size){
            if (arr[i]=="$"){
                val first=arr.copyOfRange(0,(arr.size+1)/2)
                val second=arr.copyOfRange((arr.size+1)/2,arr.size)
                if (first[0]=="T"){
                    val str=first.toString()
                    addTextview(str.substringAfter('~'))
                }
            }
        }
            applyText(res!!,data!!)
    }

    fun applyText(res:String,data: String){
        if (res=="T"){
            addTextview(data!!)
        }
    }

    private fun addTextview(data:String) {

        val textView = TextView(this)
        textView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textView.gravity = Gravity.CENTER
        textView.text = data
        binding.linearLayout.addView(textView)
    }


}