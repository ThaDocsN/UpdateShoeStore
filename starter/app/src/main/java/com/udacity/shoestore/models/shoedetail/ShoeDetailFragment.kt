package com.udacity.shoestore.models.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel:ShoesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)


        binding.btnSave.setOnClickListener {
            getShoe()
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailDestinationToShoeListDestination())
        }

        return binding.root
    }

    private fun getShoe() {
        val name        = binding.tvShoeName.text.toString()
        val size        = binding.tvShoeSize.text.toString()
        val company     = binding.tvShoeCompany.text.toString()
        val description = binding.tvShoeDescription.text.toString()

        val shoe = Shoe(name, size.toDouble(), company, description)
        viewModel.addShoe(shoe)
    }
}