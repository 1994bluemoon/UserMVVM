package vinova.henry.com.usermvvm.server

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class ServerUtil{

    private val BASE_URL = "https://lit-basin-20477.herokuapp.com"
    private var retrofit: Retrofit? = null

    fun getSOService(): WebService? {
        return getClient(BASE_URL)?.create(WebService::class.java)
    }

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit
    }
}
