package com.example.zadanie_z_toolbarem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import com.example.zadanie_z_toolbarem.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            supportActionBar?.hide() // ukrycie paska na górze
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            //rozwinięcie paska
            binding.toolbarIcon.setOnClickListener {
                binding.navView.visibility = View.VISIBLE
            }

            binding.ButtonClose.setOnClickListener {
                binding.navView.visibility = View.GONE
            }
    }
}
