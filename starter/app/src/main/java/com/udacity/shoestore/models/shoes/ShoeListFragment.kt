package com.udacity.shoestore.models.shoes

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.data.Shoe
import com.udacity.shoestore.models.data.ShoeDatabase
import com.udacity.shoestore.models.shoedetail.ShoeViewModelFactory
import com.udacity.shoestore.models.shoedetail.ShoesViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        binding.lifecycleOwner = this

        val application = requireNotNull(this.activity).application
        val dataSource = ShoeDatabase.getInstance(application).shoeDao

        val viewModel: ShoesViewModel by activityViewModels{ShoeViewModelFactory(dataSource, application)}

        val adapter = ShoeAdapter(ShoeListener {
            viewModel.onShoeClicked(it)
        })

        binding.rvShoeList.adapter = adapter

        viewModel.selectedShoe.observe(viewLifecycleOwner, {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToDisplayShoeDestination(it))
        })

        viewModel.shoeList.observe(viewLifecycleOwner, { shoes ->
           shoes?.let {
               Timber.i(adapter.itemCount.toString())
               adapter.submitList(shoes)
           }
        })


        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToShoeDetailFragment())
        }

        return binding.root
    }
}
