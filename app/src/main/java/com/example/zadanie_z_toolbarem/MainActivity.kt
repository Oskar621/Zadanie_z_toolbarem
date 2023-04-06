package com.example.zadanie_z_toolbarem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.zadanie_z_toolbarem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {

            //boolean to check if user is logged
            var ifLogged = false

            supportActionBar?.hide() // hiding the Action Bar
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            var userInfo: MutableList<String> = mutableListOf("","","")

            //expend navView
            binding.toolbarIcon.setOnClickListener {
                binding.navView.visibility = View.VISIBLE
            }

            //close navView
            binding.ButtonClose.setOnClickListener {
                binding.navView.visibility = View.GONE
            }

            //button to log in actions
            binding.ButtonLogin.setOnClickListener {

                val nickname: String = binding.InputNickname.text.toString().trim()
                val login: String = binding.InputLogin.text.toString().lowercase().trim()
                val password: String = binding.InputPassword.text.toString().lowercase().trim()

                if (nickname == "" || login == "" || password == "") {
                    Toast.makeText(applicationContext, "Wypełnij wszystkie dane", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else if (login != "oskar" || password != "swiderski") {
                    Toast.makeText(applicationContext, "Podano złe dane", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                ifLogged = true
                binding.ButtonLogOut.visibility = View.VISIBLE
                userInfo[0] = nickname
                userInfo[1] = login
                userInfo[2] = password

                Toast.makeText(applicationContext, "Pomyślnie zalogowano", Toast.LENGTH_SHORT).show()
            }
    }
}
