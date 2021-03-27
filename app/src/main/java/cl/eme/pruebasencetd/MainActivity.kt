package cl.eme.pruebasencetd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

/**
 * [X] Control de Versiones
 * [X] Consumo de Datos API
 *      [X] Permiso de Internet.
 *      [X] Cleartext si es https  -> eliminar para probar después.
 *      [X] Dependencias de Retrofit.
 *      [X] POJOs (listado y detalle).
 *      [X] Interfaz de Operaciones.
 *      [X] Cliente de Retrofit.
 * [X] Repositorio
 * [X] ViewModel
 * [X] Activar viewBinding
 * [X] Modificar el activity_main.xml
 * [X] Fragmento de Listado
 *      [X] Layout del Fragmento.
 *      [X] Layout del Item.
 *      [X] Adapter + Viewholder + Recyclerview.
 *      [X] Modificar para usar ViewBinding.
 *      [X] onClick para elemento del listado.
 * [ ] Fragmento de Detalle
 *      [X] Crear el Layout del Detalle.
 *      [ ] Crear el Fragmento que recibe 1 parámetro (id del auto).
 *      [ ] Crear el Viewmodel para consumir los datos del detalle.
 * [X] Manejo de Persistencia con ROOM
 *      [X] Dependencias.
 *      [X] DAO.
 *      [X] Cliente de base de datos.
 *      [X] Clase que extiende de application para inicializar la base de datos.
 *      [X] Agregar al manifest application.
 *      [X] Actualizar repositorio para leer de base de datos.
 * [X] Refactorización y limpieza (analyze -> inspect code)
 * [X] Test Unitario
 * [X] Test Integral
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initLog()
    }

    private fun initLog() {
        Timber.plant(Timber.DebugTree())
    }
}