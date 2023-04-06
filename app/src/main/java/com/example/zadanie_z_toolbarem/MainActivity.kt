package com.example.zadanie_z_toolbarem

import android.annotation.SuppressLint
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

            val userInfo: MutableList<String> = mutableListOf("","","")

            //expend navView
            binding.toolbarIcon.setOnClickListener {
                binding.navView.visibility = View.VISIBLE
            }

            //close navView
            binding.ButtonClose.setOnClickListener {
                binding.navView.visibility = View.GONE
            }

            binding.ButtonLogOut.setOnClickListener {
                ifLogged = false
                userInfo[0] = "Nieznany"
                userInfo[1] = ""
                userInfo[2] = "Niezalogowano"

                refreshUserData(userInfo)
                binding.linearLayout.visibility = View.VISIBLE
                binding.LoggedIn.visibility = View.GONE
                binding.ButtonLogOut.visibility = View.GONE
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
                userInfo[0] = nickname
                userInfo[1] = login
                userInfo[2] = password

                binding.linearLayout.visibility = View.GONE
                binding.LoggedIn.visibility = View.VISIBLE
                binding.ButtonLogOut.visibility = View.VISIBLE
                refreshUserData(userInfo)

                Toast.makeText(applicationContext, "Pomyślnie zalogowano", Toast.LENGTH_SHORT).show()
            }
    }

    @SuppressLint("SetTextI18n")
    fun refreshUserData(userInfo: MutableList<String>){
        binding.navUsername.text = userInfo[0]
        binding.toolbarText.text = "${userInfo[1]} ${userInfo[2]}"
    }

}
