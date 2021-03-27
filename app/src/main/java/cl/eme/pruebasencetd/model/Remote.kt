package cl.eme.pruebasencetd.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CakesAPI {

    @GET("cakes/")
    suspend fun getCakes() : Response<List<Cakes>>

    @GET("cakeDetails/{pid}")
    suspend fun getCake(@Path("pid") id: Int) : Response<CakeDetails>
}

//Cliente Retrofit

const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/cakesApi/"
class RetrofitClient {
    companion object {

        fun instance() : CakesAPI{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(CakesAPI::class.java)

        }
    }

}