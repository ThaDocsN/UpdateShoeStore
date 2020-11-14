package com.udacity.shoestore.models.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.data.Shoe


class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private val viewModel:ShoesViewModel by activityViewModels()


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
        val name        = binding.etShoeName.text.toString()
        val size        = binding.etShoeSize.text.toString()
        val company     = binding.etShoeCompany.text.toString()
        val description = binding.etShoeDescription.text.toString()

        val shoe = Shoe(name =name, size = size.toDouble(), company = company, description = description)
        viewModel.addShoe(shoe)
    }
}