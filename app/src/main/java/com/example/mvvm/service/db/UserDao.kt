//package com.example.mvvm.service.db
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//
//@Dao
//interface UserDao {
//
//    @Query("SELECT * FROM user")
//    fun getAllUser(): LiveData<List<User>>
//
//    @Insert
//    suspend fun insertUser(vararg user: User)
//
//    @Update
//    suspend fun updateUser(vararg user: User)
//}