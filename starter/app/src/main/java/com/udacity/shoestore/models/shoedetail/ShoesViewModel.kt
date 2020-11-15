package com.udacity.shoestore.models.shoedetail

import android.app.Application
import androidx.lifecycle.*
import com.udacity.shoestore.models.data.Shoe
import com.udacity.shoestore.models.data.ShoeDatabaseDao
import kotlinx.coroutines.launch
import timber.log.Timber

class ShoesViewModel(private val database:ShoeDatabaseDao, application: Application) : AndroidViewModel(application) {

    val shoeList = database.getAllShoes()


    fun addShoe(shoe: Shoe) {
        viewModelScope.launch {
            insertShoe(shoe)
        }
    }

    private suspend fun insertShoe(shoe: Shoe) {
        database.insert(shoe)
    }

}

class ShoeViewModelFactory(
    private val dataSource: ShoeDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShoesViewModel::class.java)) {
            return ShoesViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
