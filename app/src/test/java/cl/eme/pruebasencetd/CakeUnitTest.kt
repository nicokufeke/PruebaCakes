package cl.eme.pruebasencetd

import cl.eme.pruebasencetd.model.BASE_URL
import com.google.common.truth.Truth
import org.junit.Test

//Este test unitario se escribe para tener un criterio de verificación de integridad de la API//

class APIClientTest {

    @Test
    fun baseUrl() {
        // Given
        val baseUrl = BASE_URL
        val expected = "https://my-json-server.typicode.com/Himuravidal/cakesApi/"

        // When

        // Then
        Truth.assertThat(baseUrl).isEqualTo(expected)
    }
}