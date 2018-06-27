package vinova.henry.com.usermvvm

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import vinova.henry.com.usermvvm.model.User

class UserProfileViewModel : ViewModel(){

    var userRepo: UserRepository = UserRepository()
    var usersDatachange: MutableLiveData<String> = MutableLiveData()

    var users = Transformations.switchMap(usersDatachange, {
        userRepo.getResult(it)
    })

    fun set(str:String) {
        usersDatachange.value = str
    }

}