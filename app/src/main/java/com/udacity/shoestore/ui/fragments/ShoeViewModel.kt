package com.udacity.shoestore.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String> get() = _error

    private val _shoeSaved by lazy { MutableLiveData<Boolean>() }
    val shoeSaved: LiveData<Boolean> get() = _shoeSaved

    fun prepareToAddShoe(name: String, company: String, description: String, size: String) {
        _shoeSaved.value = false
        when {
            name.isEmpty() -> {
                _error.value = "Shoe Name"
            }
            company.isEmpty() -> {
                _error.value = "Shoe Company"
            }
            description.isEmpty() -> {
                _error.value = "Shoe Description"
            }
            size.isEmpty() -> {
                _error.value = "Shoe Size"
            }
            else -> {
                val shoe = Shoe(
                    name.capitalize(Locale.ROOT),
                    size.capitalize(Locale.ROOT),
                    company.capitalize(Locale.ROOT),
                    description.capitalize(Locale.ROOT)
                )
                _shoeList.value?.add(shoe)
                _shoeSaved.value = true
            }
        }
    }

    init {
        _shoeList.value = mutableListOf(
            Shoe(
                "Clown Shoes",
                "45",
                "The Clown Company",
                "These shoes are ONLY for SERIOUS clowns!"
            ),
            Shoe(
                "Wooden Shoes",
                "7.5",
                "The Dutch Shoe Company",
                "Definitely Not Casual Wear"
            )
        )
    }

}