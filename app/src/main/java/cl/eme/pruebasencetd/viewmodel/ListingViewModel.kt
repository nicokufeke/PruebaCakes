package cl.eme.pruebasencetd.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.pruebasencetd.model.Repository
import kotlinx.coroutines.launch

class ListingViewModel : ViewModel() {

    private val repository = Repository()

    val cakesList = repository.getCakes

    fun getCakes() {
        viewModelScope.launch {
            repository.getCakes()
        }
    }
}



