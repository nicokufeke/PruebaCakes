package cl.eme.pruebasencetd.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

@Dao
interface CakesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakes(cakesList: List<Cakes>)

    @Query("SELECT * FROM cakes")
    fun getCakes() : LiveData<List<Cakes>>

    @Query("SELECT * FROM cakes WHERE id=:code")
    fun getCakesId (code:Int) : LiveData<Cakes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakeDetails(cakeDetails: CakeDetails)

    @Query("SELECT * FROM cakeDetails")
    fun getCakeDetails(code: Int) : LiveData<CakeDetails>

    @Query("SELECT * FROM cakeDetails WHERE id=:code")
    fun getCakeDetailsId(code:Int) : LiveData<CakeDetails>

    @Database(entities = [Cakes::class, CakeDetails::class], version = 1)
    abstract class CakesDatabase : RoomDatabase() {
        abstract fun cakesDao() : CakesDao
    }

    class ProductsApplication : Application() {
        companion object {
            var cakesDatabase: CakesDatabase? = null
        }

        override fun onCreate() {
            super.onCreate()
            Timber.d("OnCreate de Application")
            cakesDatabase =
                Room.databaseBuilder(this, CakesDatabase::class.java, "Cakes_DataBase").build()

        }

    }
}