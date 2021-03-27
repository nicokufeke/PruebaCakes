package cl.eme.pruebasencetd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import timber.log.Timber

/**
 * [ ] Control de Versiones
 * [ ] Consumo de Datos API
 *      [X] Permiso de Internet.
 *      [X] Cleartext si es https  -> eliminar para probar después.
 *      [X] Dependencias de Retrofit.
 *      [ ] POJOs (listado y detalle).
 *      [ ] Interfaz de Operaciones.
 *      [ ] Cliente de Retrofit.
 * [ ] Repositorio
 * [ ] ViewModel
 * [ ] Activar viewBinding
 * [ ] Modificar el activity_main.xml
 * [ ] Fragmento de Listado
 *      [ ] Layout del Fragmento.
 *      [ ] Layout del Item.
 *      [ ] Adapter + Viewholder + Recyclerview.
 *      [ ] Modificar para usar ViewBinding.
 *      [ ] onClick para elemento del listado.
 * [ ] Fragmento de Detalle
 *      [ ] Crear el Layout del Detalle.
 *      [ ] Crear el Fragmento que recibe 1 parámetro (id del auto).
 *      [ ] Crear el Viewmodel para consumir los datos del detalle.
 * [ ] Manejo de Persistencia con ROOM
 *      [ ] Dependencias.
 *      [ ] DAO.
 *      [ ] Cliente de base de datos.
 *      [ ] Clase que extiende de application para inicializar la base de datos.
 *      [ ] Agregar al manifest application.
 *      [ ] Actualizar repo para leer de base de datos.
 * [ ] Refactorización y limpieza (analyze -> inspect code)
 * [ ] Test Unitario
 * [ ] Loading
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