package com.udacity.shoestore.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.ui.MainViewModel

class WelcomeViewModel: MainViewModel() {

    private val _userName by lazy { MutableLiveData<String>() }
    val userName: LiveData<String> get() = _userName

    fun setNameFromBundle(bundleName: String) {
        _userName.value = bundleName
    }
}