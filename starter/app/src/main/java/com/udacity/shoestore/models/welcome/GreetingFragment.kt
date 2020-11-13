package com.udacity.shoestore.models.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.GreetingFragmentBinding

class GreetingFragment : Fragment() {

    private lateinit var binding: GreetingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.greeting_fragment, container, false)

        binding.lifecycleOwner = this

        val viewModel:GreetingViewModel by viewModels()

        binding.viewModel = viewModel

        viewModel.onButtonClicked.observe(viewLifecycleOwner, {clicked ->
            if (clicked){
                findNavController().navigate(GreetingFragmentDirections.actionGreetingDestinationToInstructionsFragment())
                viewModel.onDone()
            }
        })

        return binding.root
    }
}