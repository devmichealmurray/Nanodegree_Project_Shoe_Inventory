package com.udacity.shoestore.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityLoginBinding

private const val NAME = "name"

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.loginActivity = this

    }

    fun loginClick() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(NAME, binding.loginNameEditText.text.toString())
        startActivity(intent)
        finish()
    }


}