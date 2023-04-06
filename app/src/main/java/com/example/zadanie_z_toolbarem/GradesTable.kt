package com.example.zadanie_z_toolbarem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GradesTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.grades_table)

        supportActionBar?.hide() // ukrycie defaultowego topbara
        val UserData = intent.getStringArrayExtra("userinfo")
        findViewById<TextView>(R.id.toolbarText).text = "${UserData?.get(1)} ${UserData?.get(2)}"
        findViewById<TextView>(R.id.navUsername).text = UserData?.get(0)
    }
}