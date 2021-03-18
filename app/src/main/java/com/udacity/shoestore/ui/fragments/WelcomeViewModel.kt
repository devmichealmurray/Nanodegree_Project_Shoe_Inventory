package com.udacity.shoestore.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel: ViewModel() {

    private val _userName by lazy { MutableLiveData<String>() }
    val userName: LiveData<String> get() = _userName

    fun setNameFromArgs(userName: String) {
        _userName.value = userName
    }

}