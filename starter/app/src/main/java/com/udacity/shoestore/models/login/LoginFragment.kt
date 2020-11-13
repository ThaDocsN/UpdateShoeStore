package com.udacity.shoestore.models.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.lifecycleOwner = this

        val viewModel: LoginViewModel by viewModels()

        binding.viewModel = viewModel

        viewModel.onLoginButton.observe(viewLifecycleOwner, { clicked ->
            if (clicked) {
                findNavController().navigate(LoginFragmentDirections.actionLoginDestinationToGreetingFragment())
                viewModel.onLoginDone()
            }
        })

        viewModel.onCreateButton.observe(viewLifecycleOwner, { clicked ->
            if (clicked) {
                findNavController().navigate(LoginFragmentDirections.actionLoginDestinationToGreetingFragment())
                viewModel.onCreateDone()
            }
        })

        return binding.root
    }
}