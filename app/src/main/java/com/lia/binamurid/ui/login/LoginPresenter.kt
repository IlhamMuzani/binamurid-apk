package com.lia.binamurid.ui.login
import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.data.model.user.DataUser
import com.lia.binamurid.data.model.user.ResponseUser
import com.lia.binamurid.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter (val view: LoginContract.View) : LoginContract.Presenter {

    init {
        view.initActivity()
        view.initListener()
        view.onLoading(false)
    }
    override fun doLogin(email: String, password: String) {
        view.onLoading(true)
        ApiService.endpoint.loginorangtua(email, password).enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                view.onLoading(false)
                if (response.isSuccessful){
                    val responseUser: ResponseUser?= response.body()
                    view.showMessage(responseUser!!.message)

                    if (responseUser!!.status) {
                        view.onResult(responseUser)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                view.onLoading(false)
            }
        })
    }

    override fun setPrefs(prefsManager: PrefsManager, dataUser: DataUser) {
        prefsManager.prefIsLogin = true
        prefsManager.prefsId = dataUser.id!!
        prefsManager.prefs_is_nama = dataUser.nama!!
        prefsManager.prefs_is_email = dataUser.email!!
        prefsManager.prefs_is_telp = dataUser.telp!!
        prefsManager.prefs_is_gender = dataUser.gender!!
//        prefsManager.prefs_is_alamat = dataUser.alamat!!
    }
}