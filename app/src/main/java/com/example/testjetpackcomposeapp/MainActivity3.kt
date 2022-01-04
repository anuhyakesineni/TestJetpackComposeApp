package com.example.testjetpackcomposeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click.setOnClickListener {
            it.visibility = View.INVISIBLE


            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, BlankFragment())
                commit()
            }
        }


    }
}