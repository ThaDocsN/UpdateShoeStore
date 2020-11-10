package com.udacity.shoestore.models.shoes

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.shoedetail.ShoesViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel:ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            for (shoe in shoes){
                binding.llShoeContainer.addView(addTextView(shoe))
                Timber.i(shoe.name)
            }
        })


        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToShoeDetailFragment())
        }

        return binding.root
    }

    private fun addTextView(shoe: Shoe): TextView? {
        val textView = TextView(context)

        textView.apply {
            layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
            text = shoe.name
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 40f)
            setTextColor(Color.BLACK)
        }
        return textView
    }

}
