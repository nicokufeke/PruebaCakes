package cl.eme.pruebasencetd.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CakesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakes(cakesList: List<Cakes>)

    @Query("SELECT * FROM cakes")
    fun getCakes(): LiveData<List<Cakes>>

    @Query("SELECT * FROM cakes WHERE id=:code")
    fun getCakesId(code: Int): LiveData<Cakes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCakeDetails(cakeDetails: CakeDetails)

    @Query("SELECT * FROM cakeDetails")
    fun getCakeDetails(): LiveData<CakeDetails>

    @Query("SELECT * FROM cakeDetails WHERE id=:code")
    fun getCakeDetailsId(code: Int): LiveData<CakeDetails>

    @Database(entities = [Cakes::class, CakeDetails::class], version = 1)
    abstract class CakesDatabase : RoomDatabase() {
        abstract fun cakesDao(): CakesDao
    }

}