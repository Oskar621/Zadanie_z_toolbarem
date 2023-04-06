package com.example.zadanie_z_toolbarem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GradesTable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_grades_table)

        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Wczytanie danych uzytkownika
        val User_Data = intent.getStringArrayExtra("userinfo")
        findViewById<TextView>(R.id.toolbarText).text = "${User_Data?.get(1)} ${User_Data?.get(2)}"
        findViewById<TextView>(R.id.navUsername).text = User_Data?.get(0)
    }
}