package com.fagorn.coolreminder

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.fagorn.coolreminder.Model.DateSubmit
import com.fagorn.coolreminder.Model.ItemModel
import com.fagorn.coolreminder.Model.TimeSubmit
import kotlinx.android.synthetic.main.activity_record.*
import java.util.*

class RecordActivity : AppCompatActivity() {
    lateinit var myDate: DateSubmit
    lateinit var myTime: TimeSubmit
    lateinit var myTask: ItemModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        backMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {

            }
            startActivity(intent)
        }
        addButton.setOnClickListener {
            myTask = ItemModel(
                HeaderTextEditText.text.toString(),
                DetailTextEditText.text.toString(),
                myTime,
                myDate
            )
            addNewItem(myTask)
            Toast.makeText(this,"Task added",Toast.LENGTH_LONG).show()
        }
        SetNowadays()
        OnClickTime()
        OnDateTime()
    }

    private fun SetNowadays() {
        val calendar: Calendar = Calendar.getInstance()
        val myYear = calendar.get(Calendar.YEAR)
        myDate = DateSubmit(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        myTime = TimeSubmit(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
    }

    private fun OnClickTime() {
        myTimePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
            myTime = TimeSubmit(hourOfDay, minute)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun OnDateTime() {
        myDatePicker.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            myDate = DateSubmit(year, monthOfYear + 1, dayOfMonth)
        }
    }
}

