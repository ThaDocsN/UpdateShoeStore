package com.udacity.shoestore.models.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoesViewModel: ViewModel() {
    private var shoeList = mutableListOf<Shoe>()
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>> = _shoes

    init {

    }

    fun addShoe(shoe: Shoe){
        shoeList.add(shoe)
        Timber.i(shoeList.size.toString())
        _shoes.value = shoeList
    }
}