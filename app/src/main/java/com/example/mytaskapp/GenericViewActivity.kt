package com.example.mytaskapp

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setMargins
import com.example.mytaskapp.databinding.ActivityGenericBinding


class GenericViewActivity:AppCompatActivity() {

    lateinit var binding : ActivityGenericBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGenericBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input = intent.getStringExtra("KEY")
        val res = input?.first().toString()
        val inputbe = input?.substring(2)
        val inputbefore=inputbe?.substringBefore('~')?.trim()
        val inputafter = inputbe?.substringAfter('~')?.trim()



//        val arr = input?.toCharArray()
//        val part= input.toString()
//        val preseg=input?.substringBefore('$')
//        val postseg=input?.substringAfter('$')

//        for (i in 0.. arr?.size!!){
//            while (arr[i]=='$'){
//                if (arr[i+1]=='T'){
//                    textViews("")
//                }
//                if (arr[i+1]=='C'){
//                    checkBoxestrue()
//                }
//                 else{
//                     radioButtonstrue()
//                 }
//            }
//        }



//        var data:Array<String>
//        var index=arr?.indexOf('@')
//        while ( arr?.size!=null){
//            if (arr?.contains('@')!!){
//                if (index != null) {
//                     data= arrayOf(arr[index+1].toString())
//                }
//            } }
//        if(inputafter?.contains('|')!!){
//            val ine=inputafter.substringAfter('|')
//        }


//        when (res) {
//            "1" -> callTextview(inputbefore!!,inputafter!!)
//            "2" -> callButtonview(inputbefore!!,inputafter!!)
//            "3" -> callCheckbox(inputbefore!!,inputafter!!)
//            "4" -> callRadioButton(inputbefore!!,inputafter!!)
//            "5" ->  callSpinner(inputbefore!!)
//        }
        when (res) {
            "T"->tview(res,inputafter!!)
            "B" -> buttonView(res,inputafter!!)
            "C" -> checkboxView(res,inputafter!!)
            "R" -> radioButtonview(res)
            "S" ->  spinnerview(res,inputbefore!!)
        }

    }

    fun tview(res:String,data: String){
        if (res=="T"){
            textViews(data)
        }
    }
    fun buttonView(res: String,dataLast:String){
        if(res=="B" ){
            button(dataLast)
        }
    }
    fun checkboxView(res:String,dataLast: String){
        if (res=="C"){
            if (dataLast?.first()=='1'){
                checkBoxestrue()
            }else{
                checkBoxesfalse()
            }
        }
    }
    fun radioButtonview(res: String){
        if (res=="R"){
            radioGroup("Select Gender")
        }
    }

    fun spinnerview(res:String,data: String){
        if (res=="S"){
            spinner()
        }
    }
    fun callTextview(dataFirst:String,dataLast:String){

            if(dataFirst=="Enter Your Name:" ){
                textViews(dataLast)
            }
        }
           fun callButtonview(dataFirst:String,dataLast:String){
               if(dataFirst=="Enter Your Name:" ){
                   button(dataLast)
               }
           }

        fun callSpinner(dataFirst: String){
            if(dataFirst=="Select City:" ){
                spinner()
            }
        }


        fun callCheckbox(dataFirst:String,dataLast: String){
            if (dataFirst?.first()=='C'){
                if (dataLast?.first()=='1'){
                    checkBoxestrue()
                }else{
                    checkBoxesfalse()
                }
            }
        }

        fun callRadioButton(dataFirst: String,dataLast: String){
            if (dataFirst=="Select Gender"){
                if (dataLast?.first()=='1'){
                    radioButtonstrue()
                }
                else{
                    radioButtonsfalse()
                }
            }
        }



    private fun textViews(data:String){
        var textlayout=LinearLayout(this)
        textlayout.orientation=LinearLayout.HORIZONTAL
        binding.linearLayout.addView(textlayout)
        var textView=TextView(this)
        textView.setText("Name : $data")
        setTextView(textView)
        textlayout.addView(textView)
        seprator()

    }
    private fun radioButtonstrue(){
            var rd=RadioGroup(this)
            rd.orientation=LinearLayout.HORIZONTAL
            binding. linearLayout.addView(rd)
            var radioButton = RadioButton(this)
            radioButton.setText("Select Gender:")
            radioButton.isChecked=true
            rd.addView(radioButton)
            setRadioButton(radioButton)
            seprator()

    }

    private fun radioButtonsfalse(){
        var rd=RadioGroup(this)
        rd.orientation=LinearLayout.HORIZONTAL
        binding. linearLayout.addView(rd)
        var radioButton = RadioButton(this)
        radioButton.setText("Select Gender:")
        radioButton.isChecked=false
        rd.addView(radioButton)
        setRadioButton(radioButton)
        seprator()

    }


    private fun radioGroup(data: String){
        val radioButton1 = RadioButton(this)
        radioButton1.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton1.setText(R.string.male)
        radioButton1.id = R.id.radioButton_male

        val radioButton2 = RadioButton(this)
        radioButton2.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        radioButton2.setText(R.string.female)
        radioButton2.id = R.id.radioButton_female


        val radioGroup = RadioGroup(this)
        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(40, 0, 0, 0)
        radioGroup.layoutParams = params

        radioGroup.addView(radioButton1)
        radioGroup.addView(radioButton2)
        binding.linearLayout.addView(radioGroup)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            var text = getString(R.string.Selected_Item)
            text += " " + getString(if (checkedId == 0) R.string.male else R.string.female)
            Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()
        }


        }

    private fun checkBoxestrue(){
        var checkbox=LinearLayout(this)
        checkbox.orientation=LinearLayout.HORIZONTAL
        binding.linearLayout.addView(checkbox)
        val checkBox = CheckBox(this);
        checkBox.isChecked=true
        checkBox.setText("CheckBox")
        setCheckBox(checkBox)
        checkbox.addView(checkBox)
        seprator()
    }

    private fun checkBoxesfalse(){
        var checkbox=LinearLayout(this)
        checkbox.orientation=LinearLayout.HORIZONTAL
        binding.linearLayout.addView(checkbox)
        val checkBox = CheckBox(this);
        checkBox.isChecked=false
        checkBox.setText("CheckBox")
        setCheckBox(checkBox)
        checkbox.addView(checkBox)
        seprator()
    }

//    private fun buttonView(data: String){
//        var buttonlayout=LinearLayout(this)
//        buttonlayout.orientation=LinearLayout.HORIZONTAL
//        binding.linearLayout.addView(buttonlayout)
//        var button=Button(this)
//        button.setOnClickListener {
//            Toast.makeText(this,"Button Clicked",Toast.LENGTH_SHORT).show()
//        }
//        button.setText("$data")
//        //setButton(button)
//        buttonlayout.addView(button)
//        seprator()
//    }
    private fun button(data: String){
        val button = Button(this)
        button.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        button.gravity = Gravity.CENTER
        button.text=data
        binding.linearLayout.addView(button)
    }

    private fun spinner(){
        val spinner = Spinner(this)
        spinner.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        val personNames = arrayOf("Pune", "Mumbai", "Chennai", "Dellhi", "Kolkata","Jaipur")
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    this@GenericViewActivity,
                    "City Selected is" + ""+ personNames[position],
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        binding.linearLayout.addView(spinner)
    }

    private fun setTextView(textView: TextView){
        val params=LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(setDpPx(20f))
        textView.setTextColor(Color.CYAN)
        textView.textSize=16f
        textView.layoutParams=params
    }
    private fun setRadioButton(radioButton: RadioButton){
        val params=LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(setDpPx(20f),setDpPx(20f),0,0)
        radioButton.layoutParams=params
    }
    private fun setCheckBox(checkBox: CheckBox){
        val params=LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        params.setMargins(setDpPx(20f),setDpPx(20f),0,0)
        checkBox.layoutParams=params
    }
    private fun setDpPx(dp:Float): Int {
        val metrics = Resources.getSystem().getDisplayMetrics();
        val px = dp * (metrics.densityDpi / 160f);
        return Math.round(px)
    }

    private fun seprator(){
        val lineLayout = LinearLayout(this)
        lineLayout.setBackgroundColor(Color.GRAY)
        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            2)
        params.setMargins(0, setDpPx(10f), 0, setDpPx(10f))
        lineLayout.layoutParams = params
        binding.linearLayout.addView(lineLayout)
    }

}