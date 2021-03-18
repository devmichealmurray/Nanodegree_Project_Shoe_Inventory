package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


private const val TAG = "WELCOME FRAGMENT"

class Welcome: Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private val welcomeViewModel: WelcomeViewModel by viewModels()
    private val args: WelcomeArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.viewModel = welcomeViewModel
        binding.fragment = this
        binding.lifecycleOwner = this
        args.userName?.let { welcomeViewModel.setNameFromArgs(it) }
        return binding.root
    }

    fun navigateToInstructions() {
        findNavController().navigate(R.id.action_welcome_to_instructions)
    }

}