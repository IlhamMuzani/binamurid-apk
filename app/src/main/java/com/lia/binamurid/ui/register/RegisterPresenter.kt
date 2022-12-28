package com.lia.binamurid.ui.register

import com.lia.binamurid.data.model.user.ResponseUser
import com.lia.binamurid.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterPresenter (val view: RegisterContract.View) : RegisterContract.Presenter {

    init {
        view.initActivity()
        view.initListener()
        view.onLoading(false)
    }

    override fun insertregister(
        nama: String,
        email: String,
        telp: String,
        gender: String,
        alamat: String,
        password: String,
        password_confirmation: String
    ) {
        view.onLoading(true)
        ApiService.endpoint.register(nama, email, telp, gender, alamat, password, password_confirmation).enqueue(object: Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                view.onLoading(false)
                if (response.isSuccessful) {
                    val responseUser: ResponseUser? = response.body()
                    view.onResult(responseUser!!)
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                view.onLoading(false)
            }

        })
    }

}