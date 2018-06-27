package vinova.henry.com.usermvvm

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import vinova.henry.com.usermvvm.model.ResultResponse
import vinova.henry.com.usermvvm.model.User
import vinova.henry.com.usermvvm.server.ServerUtil
import kotlin.concurrent.fixedRateTimer

class UserRepository {

    fun getResult(str:String): MutableLiveData<List<User>?> {
        // This is not an optimal implementation, we'll fix it below
        var result: MutableLiveData<List<User>?> = MutableLiveData()

        var sv = ServerUtil()
        sv.getSOService()?.getServerData("0", "20")?.enqueue(object : retrofit2.Callback<ResultResponse> {
            override fun onResponse(call: Call<ResultResponse>?, response: Response<ResultResponse>?) {
                result.value = response?.body()?.users?.filter { it.username.toLowerCase().contains(str) }
                if (str.equals("")){
                    result.value = response?.body()?.users
                }
            }

            override fun onFailure(call: Call<ResultResponse>?, t: Throwable?) {
                Log.d("getdata", "fail")
            }
        })
        return result
    }
}