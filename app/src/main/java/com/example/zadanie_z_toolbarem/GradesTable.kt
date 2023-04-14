package com.example.zadanie_z_toolbarem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationView


class GradesTable : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_grades_table)
        supportActionBar?.hide() // ukrycie defaultowego topbara

        // Wczytanie danych uzytkownika
        val userData = intent.getStringArrayExtra("userData")
        findViewById<TextView>(R.id.toolbarText).text = "${userData?.get(1)} ${userData?.get(2)}"
        findViewById<TextView>(R.id.navUsername).text = userData?.get(0)

        findViewById<ImageView>(R.id.toolbarIcon).setOnClickListener {
            findViewById<NavigationView>(R.id.navView).visibility = View.VISIBLE
        }
        //close navView
        findViewById<Button>(R.id.ButtonClose).setOnClickListener {
            findViewById<NavigationView>(R.id.navView).visibility = View.GONE
        }

        findViewById<Button>(R.id.ButtonHomepage).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java).putExtra("userData", userData))
        }
        findViewById<Button>(R.id.ButtonGrades).setOnClickListener {
            Toast.makeText(this, "Jesteś już na stronie z ocenami", Toast.LENGTH_SHORT).show()
        }

        findViewById<Button>(R.id.ButtonUserInfo).setOnClickListener {
            startActivity(Intent(this, UserInformations::class.java).putExtra("userData", userData))
        }


    }
}