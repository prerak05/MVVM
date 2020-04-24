package com.example.mvvm.module.setting

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.service.db.DatabaseHelper
import com.example.mvvm.service.db.User
import com.example.mvvm.utility.SharedPref

class SettingViewModel(application: Application) : AndroidViewModel(application) {
    private val databaseHelper = DatabaseHelper(application)
    private val sharedPref = SharedPref(application)
    private lateinit var email: String
    private lateinit var userName: String
    private var id: Int = 0

    val user = databaseHelper.getAllUser()

    fun updateUser(pass: String) {
        if (user.size > 0) {
            for (i in 0..user.size - 1) {
                if (user.get(i).email.equals(sharedPref.getValue("email", "").toString())) {
                    email = user[i].email
                    userName = user[i].name
                    id = user[i].id
                }
            }
            databaseHelper.updateUser(
                User(
                    id = id,
                    name = userName,
                    email = email,
                    password = pass
                )
            )
        }
    }

    fun logout() {
        sharedPref.clear()
    }
}