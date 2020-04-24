package com.example.mvvm.module.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.module.login.viewmodel.LoginViewModel
import com.example.mvvm.module.registration.view.RegistrationActivity
import com.example.mvvm.module.sidedrawer.DrawerActivity
import com.example.mvvm.utility.SharedPref
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private lateinit var viewModel: LoginViewModel
    private lateinit var email: String
    private lateinit var pass: String
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        sharedPref = SharedPref(this)
        onLoginClick()
        redirectToRegistration()
    }

    private fun redirectToRegistration() {
        tvLblRegistration.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
    }

    private fun onLoginClick() {
        btnLogin.setOnClickListener {
            var context = this
            if (isValid())
                if (viewModel.checkUser(email, pass)) {
                    sharedPref.saveValue("isLogin", "true")
                    sharedPref.saveValue("email", email)
                    startActivity(Intent(this, DrawerActivity::class.java))
                    finish()
                } else {
                    Snackbar.make(mainView, "Please enter valid credential", Snackbar.LENGTH_LONG)
                        .show()
                }
        }
    }

    private fun isValid(): Boolean {
        email = edtEmail.text.toString().trim()
        pass = edtPass.text.toString().trim()
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Please enter valid email"
            return false
        } else if (pass.isEmpty()) {
            edtPass.error = "Please enter password"
            return false
        }
        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
