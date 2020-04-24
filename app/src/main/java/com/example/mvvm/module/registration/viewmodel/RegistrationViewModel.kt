package com.example.mvvm.module.registration.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.lifecycle.viewModelScope
import com.example.mvvm.module.registration.view.RegistrationActivity
import com.example.mvvm.service.db.DatabaseHelper
import com.example.mvvm.service.db.User
import kotlinx.coroutines.launch


class RegistrationViewModel(
    application: Application,
    context: RegistrationActivity
) : ViewModel() {
    private var databaseHelper: DatabaseHelper = DatabaseHelper(context)
    //    private var repository: UserRepository = UserRepository(application)
    //    val allUser: LiveData<List<User>>
    var context: Context = context


//    fun getAllUser() = repository.allUser

    fun checkUser(email: String): Boolean {
        return databaseHelper.checkUser(email)
    }

    fun insertUser(user: User) = viewModelScope.launch {
        //        repository.insertUser(user)
        databaseHelper.addUser(user)
    }

    class RegisterFactory(private val application: Application, activity: RegistrationActivity) :
        NewInstanceFactory() {
        private val context: RegistrationActivity
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RegistrationViewModel(application, context) as T
        }

        init {
            context = activity
        }
    }
}