package com.udacity.shoestore.models.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _onLoginButton = MutableLiveData<Boolean>()
    val onLoginButton: LiveData<Boolean> = _onLoginButton

    private val _onCreateButton = MutableLiveData<Boolean>()
    val onCreateButton: LiveData<Boolean> = _onCreateButton

    init {
        _onLoginButton.value  = false
        _onCreateButton.value = false
    }

    fun onLoginClicked() {
        _onLoginButton.value = true
    }

    fun onLoginDone() {
        _onLoginButton.value = false
    }

    fun onCreateClicked() {
        _onCreateButton.value = true
    }

    fun onCreateDone() {
        _onCreateButton.value = false
    }
}