package com.udacity.shoestore.models.instructions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstructionsViewModel: ViewModel() {

    private val _onButtonClick = MutableLiveData<Boolean>()
    val onButtonClick:LiveData<Boolean> = _onButtonClick

    init {
        _onButtonClick.value = false
    }

    fun onClick(){
        _onButtonClick.value = true
    }

    fun done(){
        _onButtonClick.value = false
    }
}