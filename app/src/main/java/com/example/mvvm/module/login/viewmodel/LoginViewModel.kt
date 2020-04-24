package com.example.mvvm.module.login.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm.service.db.DatabaseHelper

//import com.example.mvvm.service.repository.UserRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var databaseHelper: DatabaseHelper = DatabaseHelper(application)

    fun checkUser(email: String, pass: String): Boolean = databaseHelper.checkUser(email, pass)
}