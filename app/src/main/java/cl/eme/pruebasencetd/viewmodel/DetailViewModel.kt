package cl.eme.pruebasencetd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.pruebasencetd.model.CakeDetails
import cl.eme.pruebasencetd.model.Repository
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val repository = Repository()
/*
    fun getCakeDetail(id: String): LiveData<CakeDetails> {
        viewModelScope.launch {
            repository.getCakeDetails(id) {
            }
            return repository.getCakeDetails(id.toInt())
        }
    }

 */
}
