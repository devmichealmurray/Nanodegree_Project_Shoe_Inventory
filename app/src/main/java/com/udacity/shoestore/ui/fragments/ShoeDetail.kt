package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import org.jetbrains.anko.support.v4.alert

class ShoeDetail : Fragment() {

    private lateinit var shoeDetailBinding: FragmentShoeDetailBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Keeps EditText Fields Above the Keyboard
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        shoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        shoeDetailBinding.fragment = this
        shoeViewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        return shoeDetailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shoeViewModel.apply {
            error.observe(viewLifecycleOwner, errorObserver)
            shoeSaved.observe(viewLifecycleOwner, shoeSavedObserver)
        }
    }

    fun onCancelClick() {
        findNavController().popBackStack()
    }

    fun onSaveClick() {
        shoeViewModel.prepareToAddShoe(
            shoeDetailBinding.shoeNameEdittext.text.toString(),
            shoeDetailBinding.shoeCompanyEdittext.text.toString(),
            shoeDetailBinding.shoeDescriptionEdittext.text.toString(),
            shoeDetailBinding.shoeSizeEdittext.text.toString()
        )
    }

    private val errorObserver = Observer<String> { errorMessage ->
        alert {
            title = getString(R.string.error)
            message = "Do Not Leave $errorMessage Field Empty"
            isCancelable = false
            positiveButton(getString(R.string.ok)) { dialog ->
                dialog.dismiss()
            }
        }.show()
    }

    private val shoeSavedObserver = Observer<Boolean> {
        if (it) findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
    }
}