package com.udacity.shoestore.models.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)

        binding.lifecycleOwner = this

        val viewModel:InstructionsViewModel by viewModels()

        binding.viewModel = viewModel

        viewModel.onButtonClick.observe(viewLifecycleOwner, {clicked ->
            if (clicked){
                findNavController().navigate(InstructionsFragmentDirections.actionInstructionsDestinationToShoeListFragment())
                viewModel.done()
            }
        })

        return binding.root
    }

}