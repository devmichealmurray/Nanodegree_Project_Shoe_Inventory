package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeList: Fragment() {

    private lateinit var binding: FragmentShoelistBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_shoelist, container, false)
        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        shoeViewModel.shoeList.observe(viewLifecycleOwner, shoeListObserver)
        binding.fragment = this

        return binding.root
    }

    fun onFabClick() {
        findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
    }

    private val shoeListObserver = Observer<MutableList<Shoe>> { shoeList ->
        for (shoe in shoeList) {
            val itemBinding = ItemShoeBinding.inflate(layoutInflater, null, false)
            itemBinding.shoe = shoe
            binding.scrollViewLayout.addView(itemBinding.root)
        }
    }
}