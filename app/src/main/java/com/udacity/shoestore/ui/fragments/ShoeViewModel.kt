package com.udacity.shoestore.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import java.util.*

class ShoeViewModel : ViewModel() {

    val newShoe = Shoe("", "", "", "")

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    private val _error by lazy { MutableLiveData<String>() }
    val error: LiveData<String> get() = _error

    private val _shoeSaved by lazy { MutableLiveData<Boolean>() }
    val shoeSaved: LiveData<Boolean> get() = _shoeSaved

    fun onSaveClick() {
        prepareToAddShoe(newShoe)
    }

    private fun prepareToAddShoe(newShoe: Shoe) {
        _shoeSaved.value = false
        when {
            newShoe.name?.isEmpty() == true -> {
                _error.value = "Shoe Name"
            }
            newShoe.company?.isEmpty() == true -> {
                _error.value = "Shoe Company"
            }
            newShoe.description?.isEmpty() == true -> {
                _error.value = "Shoe Description"
            }
            newShoe.size?.isEmpty() == true -> {
                _error.value = "Shoe Size"
            }
            else -> {
                val shoe = Shoe(
                    newShoe.name?.capitalize(Locale.ROOT),
                    newShoe.size?.capitalize(Locale.ROOT),
                    newShoe.company?.capitalize(Locale.ROOT),
                    newShoe.description?.capitalize(Locale.ROOT)
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