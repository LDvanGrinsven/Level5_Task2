package com.example.level5_task2.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.level5_task2.R
import com.example.level5_task2.database.Game

import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.content_add.*
import java.util.*

const val EXTRA_GAME = "EXTRA_GAME"

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->

            if (tvTitle.text == null){
                Snackbar.make(view, "Please enter a title", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            if (tvPlatform.text == null){
                Snackbar.make(view, "Please enter a platform type", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            if (tvDay.text!!.length > 2 || tvMonth.text!!.length > 2 || tvYear.text!!.length > 4){
                Snackbar.make(view, "The date format is incorrect", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
            else{
                val date = GregorianCalendar(
                    tvYear.text.toString().toInt(),
                    tvMonth.text.toString().toInt()-1,
                    tvDay.text.toString().toInt()
                )
                val game = Game(
                    tvTitle.text.toString(),
                    date.timeInMillis,
                    tvPlatform.text.toString()
                )
                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_GAME, game)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
    }

}
