package com.example.mvvm.utility

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SharedPref(context: Context) {
    //ToDo this class helps for store temporary data
    var mSharedPreferences: SharedPreferences
    var mEditor: Editor

    //Todo: data save method
    fun saveValue(key: String, value: String?): String {
        mEditor = mSharedPreferences.edit()
        mEditor.putString(key, value)
        mEditor.commit()
        return key
    }

    //Todo: get value method
    fun getValue(key: String?, value: String?): String? {
        return mSharedPreferences.getString(key, value)
    }

    fun clear(){
        mEditor = mSharedPreferences.edit()
        mEditor.clear()
        mEditor.apply()
    }

    companion object {
        const val MY_PREF = "my_pref"
    }

    init {
        mSharedPreferences = context.getSharedPreferences(
            MY_PREF,
            Context.MODE_PRIVATE
        )
        mEditor = mSharedPreferences.edit()
    }
}