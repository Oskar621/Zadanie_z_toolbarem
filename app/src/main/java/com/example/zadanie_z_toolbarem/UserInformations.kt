package com.example.zadanie_z_toolbarem

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.navigation.NavigationView

class UserInformations : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_informations)

        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Wczytanie danych uzytkownika
        val userData = intent.getStringArrayExtra("userData")
        findViewById<TextView>(R.id.toolbarText).text = "${userData?.get(1)} ${userData?.get(2)}"
        findViewById<TextView>(R.id.navUsername).text = userData?.get(0)

        findViewById<TextView>(R.id.imie).text = findViewById<TextView>(R.id.imie).text.toString() + userData?.get(1)
        findViewById<TextView>(R.id.nazwisko).text = findViewById<TextView>(R.id.nazwisko).text.toString() + userData?.get(2)


        findViewById<ImageView>(R.id.toolbarIcon).setOnClickListener {
            findViewById<NavigationView>(R.id.navView).visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.ButtonClose).setOnClickListener {
            findViewById<NavigationView>(R.id.navView).visibility = View.GONE
        }

        findViewById<Button>(R.id.ButtonHomepage).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).putExtra("userData", userData))
        }
        findViewById<Button>(R.id.ButtonGrades).setOnClickListener {
            startActivity(Intent(this, GradesTable::class.java).putExtra("userData", userData))
        }

        findViewById<Button>(R.id.ButtonUserInfo).setOnClickListener {
            Toast.makeText(this, "Jesteś już na stronie z informacjami o użytkowniku", Toast.LENGTH_SHORT).show()
        }


    }
}