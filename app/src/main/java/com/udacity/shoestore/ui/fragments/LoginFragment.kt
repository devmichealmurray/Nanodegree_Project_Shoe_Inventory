package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var fragmentLoginBinding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Keeps EditText Fields Above the Keyboard
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        fragmentLoginBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_login, container, false)
        fragmentLoginBinding.fragment = this

        return fragmentLoginBinding.root
    }

    fun onButtonClick() {
        val userName = fragmentLoginBinding.loginNameEditText.text.toString()
        findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcome(userName))
    }

}