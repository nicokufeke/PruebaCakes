package cl.eme.pruebasencetd.model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

@Dao
interface Products2Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Cakes(products2List: List<Cakes>)

    @Query("SELECT * FROM product2")
    fun getCakes() : LiveData<List<Products2>>

    @Query("SELECT * FROM product2 WHERE id=:code")
    fun getProductId2 (code:Int) : LiveData<Products2>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductDetail2(productDetail2: ProductDetail2)

    @Query("SELECT * FROM productDetail2")
    fun getProductDetail2(code: Int) : LiveData<ProductDetail2>

    @Query("SELECT * FROM productDetail2 WHERE id=:code")
    fun getProductDetailId2(code:Int) : LiveData<ProductDetail2>

    @Database(entities = [Products2::class, ProductDetail2::class], version = 1)
    abstract class Products2Database : RoomDatabase() {
        abstract fun products2Dao() : Products2Dao
    }

    class ProductsApplication : Application() {
        companion object {
            var products2Database: Products2Database? = null
        }

        override fun onCreate() {
            super.onCreate()
            Timber.d("OnCreate de Application")
            products2Database =
                Room.databaseBuilder(this, Products2Database::class.java, "Product_DataBase").build()

        }

    }
}