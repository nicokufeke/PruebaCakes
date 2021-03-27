package cl.eme.pruebasencetd.model

import androidx.lifecycle.LiveData
import timber.log.Timber

class Repository {

    private val cakesDao = CakesApplication.cakesDatabase!!.cakesDao()
    val getCakes = cakesDao.getCakes()
    val getCakeDetails = cakesDao.getCakeDetails()

    suspend fun getCakes() {
        Timber.d("getCakes from API")
        val response = RetrofitClient.instance().getCakes()

        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    cakesDao.insertCakes(it)
                }
            }
            false -> Timber.e("${response.code()} - ${response.errorBody()}")
        }
        fun getCakesId(code: Int): LiveData<Cakes> {
            return cakesDao.getCakesId(code)

        }

        suspend fun getCakeDetails(code: Int) {
            Timber.d("getCakeDetails from API")
            val responseDetail = RetrofitClient.instance().getCake(code)

            when (responseDetail.isSuccessful) {
                true -> {
                    responseDetail.body()?.let {
                        cakesDao.insertCakeDetails(it)
                    }
                }
                false -> Timber.e("${responseDetail.code()} - ${responseDetail.errorBody()}")
            }
            fun getCakeDetails(code: Int): LiveData<CakeDetails> {
                return cakesDao.getCakeDetailsId(code)
            }

        }

    }

}

