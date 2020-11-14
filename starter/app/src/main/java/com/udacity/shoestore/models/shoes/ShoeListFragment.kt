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
import com.udacity.shoestore.models.shoedetail.ShoesViewModel
import timber.log.Timber

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_list_fragment, container, false)

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            for (shoe in shoes) {
                binding.llShoeContainer.addView(addTextView(shoe))

                Timber.i(shoe.name)
            }
            binding.root.invalidate()
        })


        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListDestinationToShoeDetailFragment())
        }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun addTextView(shoe: Shoe): TextView? {
        val textView = TextView(context)

        textView.apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            val sb = StringBuilder()
            text = sb.appendLine("Shoe name: ${shoe.name}")
                .appendLine("Shoe size: ${shoe.size}")
                .appendLine("Company Name: ${shoe.company}")
                .append("Shoe Description: ${shoe.description}")

            setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
            setTextColor(Color.BLACK)
        }
        return textView
    }

}
