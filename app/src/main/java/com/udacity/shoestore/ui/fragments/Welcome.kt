package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


private const val TAG = "WELCOME FRAGMENT"

class Welcome: Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val welcomeViewModel: WelcomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        binding.viewModel = welcomeViewModel
        binding.fragment = this
        binding.lifecycleOwner = this

        // Takes bundle sent from Login Activity and sends it to the ViewModel to be displayed
        activity?.intent?.extras?.getString("name")?.let {
            welcomeViewModel.setNameFromBundle(it)
        }

        return binding.root
    }

    fun navigateToInstructions() {
        findNavController().navigate(R.id.action_welcome_to_instructions)
    }

}