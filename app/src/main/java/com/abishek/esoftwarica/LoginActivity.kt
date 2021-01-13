package com.abishek.esoftwarica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etun: EditText
    private lateinit var etpw: EditText
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding()
        listener()
    }

    private fun listener() {


        btnlogin.setOnClickListener {
            if (validation()) {
                val user = etun.text.toString()
                val password = etpw.text.toString()

                if (user == "softwarica" && password == "coventry") {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Incorrect Username or Password ", Toast.LENGTH_LONG)
                        .show()
                }

            }
        }
    }

    private fun validation(): Boolean {

        if (TextUtils.isEmpty(etun.text)) {
            etun.error = "Enter the Username"
            etun.requestFocus()
            return false
        } else if (TextUtils.isEmpty(etpw.text)) {
            etpw.error = "Enter the password"
            etpw.requestFocus()
            return false
        } else {
            return true
        }
    }


    private fun binding() {
        etun = findViewById(R.id.etun)
        etpw = findViewById(R.id.etpw)
        btnlogin = findViewById(R.id.btnlogin)
    }
}