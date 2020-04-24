package com.example.mvvm.module.splashscreen.view

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.MainActivity
import com.example.mvvm.R
import com.example.mvvm.module.login.view.LoginActivity
import com.example.mvvm.module.sidedrawer.DrawerActivity
import com.example.mvvm.module.splashscreen.viewmodel.SplashState
import com.example.mvvm.module.splashscreen.viewmodel.SplashViewModel
import com.example.mvvm.utility.SharedPref

class SplashScreenActivity : AppCompatActivity() {
    //https://api.covid19india.org/data.json
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        sharedPref = SharedPref(this)
        val splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)
        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
            }
        })
    }

    private fun goToMainActivity() {
        if (sharedPref.getValue("isLogin", "").equals("true"))
            startActivity(Intent(this, DrawerActivity::class.java))
        else
            startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
