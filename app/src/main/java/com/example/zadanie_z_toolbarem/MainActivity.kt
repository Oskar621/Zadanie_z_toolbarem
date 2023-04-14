package com.example.zadanie_z_toolbarem

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.zadanie_z_toolbarem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        @SuppressLint("SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {

            //boolean to check if user is logged
            var ifLogged = false

            supportActionBar?.hide() // hiding the Action Bar
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)

            var userData = arrayOf("","","")
            val data = intent.getStringArrayExtra("userData")

            if (data != null){
                ifLogged = true
                userData = data
                binding.linearLayout.visibility = View.GONE
                binding.LoggedIn.visibility = View.VISIBLE
                binding.ButtonLogOut.visibility = View.VISIBLE
                refreshUserData(userData)
            }


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
                userData.set(0, "Nieznany")
                userData.set(1, "")
                userData.set(2,"Niezalogowano")
                refreshUserData(userData)
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
                userData[0] = nickname
                userData[1] = login
                userData[2] = password

                binding.linearLayout.visibility = View.GONE
                binding.LoggedIn.visibility = View.VISIBLE
                binding.ButtonLogOut.visibility = View.VISIBLE
                refreshUserData(userData)

                Toast.makeText(applicationContext, "Pomyślnie zalogowano", Toast.LENGTH_SHORT).show()
            }

            binding.ButtonHomepage.setOnClickListener {
                Toast.makeText(this, "Jesteś już na stronie głównej", Toast.LENGTH_SHORT).show()
            }
            binding.ButtonGrades.setOnClickListener {
                if (ifLogged){
                    startActivity(Intent(this, GradesTable::class.java).putExtra("userData", userData))
                } else
                    Toast.makeText(this, "Najpierw zaloguj się!", Toast.LENGTH_SHORT).show()
            }

            binding.ButtonUserInfo.setOnClickListener {
                if (ifLogged){
                    startActivity(Intent(this, UserInformations::class.java).putExtra("userData", userData))
                } else
                    Toast.makeText(this, "Najpierw zaloguj się!", Toast.LENGTH_SHORT).show()

            }
    }

    @SuppressLint("SetTextI18n")
    fun refreshUserData(userData: Array<String>){
        binding.navUsername.text = userData[0]
        binding.toolbarText.text = "${userData[1]} ${userData[2]}"
    }

}
