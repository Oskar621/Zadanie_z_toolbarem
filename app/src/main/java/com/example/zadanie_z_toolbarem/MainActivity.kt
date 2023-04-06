package com.example.zadanie_z_toolbarem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zadanie_z_toolbarem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

        }
    }
}
