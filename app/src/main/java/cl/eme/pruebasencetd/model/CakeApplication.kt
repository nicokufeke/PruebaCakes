package cl.eme.pruebasencetd.model

import android.app.Application
import androidx.room.Room
import timber.log.Timber

class CakesApplication : Application() {
    companion object {
        var cakesDatabase: CakesDao.CakesDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        Timber.d("OnCreate de Application")
        cakesDatabase =
            Room.databaseBuilder(this, CakesDao.CakesDatabase::class.java, "Cakes_DataBase").build()

    }

}
