package com.udacity.shoestore.models.shoedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.data.Shoe
import timber.log.Timber

class ShoesViewModel : ViewModel() {

    private var _shoes = MutableLiveData<ArrayList<Shoe>>()
    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    init {
        _shoes.value = ArrayList()
    }

    fun addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe)
        Timber.i(shoes.value.toString())
    }
}