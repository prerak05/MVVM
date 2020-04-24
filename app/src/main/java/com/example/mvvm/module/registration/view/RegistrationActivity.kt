package com.example.mvvm.module.registration.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.module.login.view.LoginActivity
import com.example.mvvm.module.registration.viewmodel.RegistrationViewModel
import com.example.mvvm.service.db.User
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    private lateinit var viewModel: RegistrationViewModel
    private lateinit var factory: RegistrationViewModel.RegisterFactory
    private lateinit var userName: String
    private lateinit var email: String
    private lateinit var pass: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        factory = RegistrationViewModel.RegisterFactory(application, this)
        viewModel = ViewModelProviders.of(this, factory).get(RegistrationViewModel::class.java)
        onRegisterClick()
        redirectToLogin()
    }

    private fun redirectToLogin() {
        tvLblRedirectToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun onRegisterClick() {
        btnRegister.setOnClickListener {
            if (isValid()) {
                if (!viewModel.checkUser(email)) {
                    viewModel.insertUser(User(name = userName, email = email, password = pass))
                    startActivity(Intent(this@RegistrationActivity, LoginActivity::class.java))
                    finish()
                } else {
                    edtEmail.setError("Email already available")
                }
            }
        }
    }

    private fun isValid(): Boolean {
        userName = edtUserName.text.toString().trim()
        email = edtEmail.text.toString().trim()
        pass = edtPass.text.toString().trim()

        if (userName.isEmpty()) {
            edtUserName.setError("Please enter user name")
            return false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtEmail.error = "Please enter valid email"
            return false
        } else if (pass.isEmpty()) {
            edtPass.error = "Please enter password"
            return false
        }
        return true
    }
}
