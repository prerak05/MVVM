package com.example.mvvm.module.setting

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvm.R
import com.example.mvvm.module.login.view.LoginActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_setting.*

class SettingFragment : Fragment() {

    private lateinit var viewModel: SettingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(SettingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_setting, container, false)
        val edtPass = root.findViewById<EditText>(R.id.edtChangePass)
        val btnChangePassword = root.findViewById<Button>(R.id.btnChangePass)
        val btnLogout = root.findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            viewModel.logout()
            val intent = Intent(this.context, LoginActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }

        btnChangePassword.setOnClickListener {
            val pass = edtPass.text.toString().trim()
            if (pass.isEmpty()) {
                edtPass.error = "Enter password"
                return@setOnClickListener
            } else {
                viewModel.updateUser(pass)
                Snackbar.make(settingView, "Password change successfully", Snackbar.LENGTH_SHORT)
                    .show()
            }
        }

        return root
    }
}
