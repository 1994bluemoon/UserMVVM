package vinova.henry.com.usermvvm.server

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import vinova.henry.com.usermvvm.model.ResultResponse
import vinova.henry.com.usermvvm.model.User

interface WebService{
    @GET("users?")
    fun getServerData(@Query("page") page: String, @Query("limit") limit: String): Call<ResultResponse>
}