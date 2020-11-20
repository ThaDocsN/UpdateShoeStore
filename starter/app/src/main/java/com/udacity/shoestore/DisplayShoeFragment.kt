package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.DisplayShoeFragmentBinding

class DisplayShoeFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:DisplayShoeFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.display_shoe_fragment,container,false)
        val args = DisplayShoeFragmentArgs.fromBundle(requireArguments()).Shoe

        binding.shoe = args
        return binding.root
    }
}