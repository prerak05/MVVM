package com.example.mvvm.module.sidedrawer

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mvvm.R
import com.example.mvvm.service.db.DatabaseHelper
import com.example.mvvm.utility.SharedPref
import com.google.android.material.navigation.NavigationView


class DrawerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var sharedPref: SharedPref
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        sharedPref = SharedPref(this)
        databaseHelper = DatabaseHelper(this)
        email = sharedPref.getValue("email", "").toString()
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val hView: View = navView.getHeaderView(0)
        val navController = findNavController(R.id.nav_host_fragment)
        val tvUserName = hView.findViewById<TextView>(R.id.tvUsername)
        val tvEmail = hView.findViewById<TextView>(R.id.tvEmail)
        val user = databaseHelper.getAllUser()
        if (user.size > 0) {
            for (i in 0..user.size - 1) {
                if (user.get(i).email.equals(email)) {
                    tvEmail.text = user[i].email
                    tvUserName.text = user[i].name
                }
            }
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_indian_corona, R.id.nav_setting
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
