package com.example.zadanie_z_toolbarem

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie_z_toolbarem.databinding.ActivityMainBinding

class GradesTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_grades_table)
        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Wczytanie danych uzytkownika
        val userData = intent.getStringArrayExtra("userinfo")
        findViewById<TextView>(R.id.toolbarText).text = "${userData?.get(1)} ${userData?.get(2)}"
        findViewById<TextView>(R.id.navUsername).text = userData?.get(0)
    }
}