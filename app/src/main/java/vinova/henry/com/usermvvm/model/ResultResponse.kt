package vinova.henry.com.usermvvm.model

import android.arch.lifecycle.LiveData
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ResultResponse(var status: String? = null, var users: List<User>? = null) {
    /*@SerializedName("status")
    var status: String? = null

    @SerializedName("users")
    var users: List<User>? = null*/
}