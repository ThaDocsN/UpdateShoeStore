package com.udacity.shoestore.models.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GreetingViewModel:ViewModel() {

    private val _onButtonClicked = MutableLiveData<Boolean>()
    val onButtonClicked: LiveData<Boolean> = _onButtonClicked

    init {
        _onButtonClicked.value = false
    }

    fun onClicked(){
        _onButtonClicked.value = true
    }

    fun onDone(){
        _onButtonClicked.value = false
    }
}