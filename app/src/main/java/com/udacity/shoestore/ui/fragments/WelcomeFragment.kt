package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var welcomeViewModel: WelcomeViewModel
    private val args: WelcomeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        welcomeViewModel = ViewModelProvider(this).get(WelcomeViewModel::class.java)
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