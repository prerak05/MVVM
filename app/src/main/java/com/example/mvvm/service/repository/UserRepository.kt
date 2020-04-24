//package com.example.mvvm.service.repository
//
//import android.app.Application
//import androidx.lifecycle.LiveData
//import com.example.mvvm.service.db.User
//import com.example.mvvm.service.db.UserDao
//import com.example.mvvm.service.db.UserDatabase
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlin.coroutines.CoroutineContext
//
//class UserRepository(application: Application) : CoroutineScope {
//
//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main
//
//    private var userDao: UserDao?
//
//
//    init {
//        val db = UserDatabase.getDatabase(application)
//        userDao = db?.userDao()
//    }
//
//    val allUser: LiveData<List<User>>? = userDao?.getAllUser()
//
////    suspend fun getUser(email: String, password: String) {
////        userDao?.getUser(email, password)
////    }
//
//    suspend fun insertUser(user: User) {
//        userDao?.insertUser(user)
//    }
//
//    suspend fun updateUser(user: User) {
//        userDao?.updateUser(user)
//    }
//}