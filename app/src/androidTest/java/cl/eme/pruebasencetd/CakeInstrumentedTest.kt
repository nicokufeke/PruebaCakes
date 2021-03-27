package cl.eme.pruebasencetd

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import cl.eme.pruebasencetd.model.Cakes
import cl.eme.pruebasencetd.model.CakesDao
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test

import org.junit.Before
import org.junit.Rule

class CarDBTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    // Instancias de DAO y database
    private lateinit var cDao: CakesDao
    private lateinit var db: CakesDao.CakesDatabase


    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, CakesDao.CakesDatabase::class.java).build()
        cDao = db.cakesDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun insertCar_empty() = runBlocking {
        // Given
        val cakesList = listOf<Cakes>()

        // When
        cDao.insertCakes(cakesList)

        // Then
        cDao.getCakes().observeForever {
            assertThat(it).isNotNull()
            assertThat(it).isEmpty()
        }
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat(appContext.packageName).isEqualTo("cl.dal.cars")
    }
}