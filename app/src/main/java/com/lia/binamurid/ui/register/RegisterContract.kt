package com.lia.binamurid.ui.register

import com.lia.binamurid.data.model.user.ResponseUser

interface RegisterContract {

    interface Presenter {
      fun insertregister(nama: String, email: String, telp: String, gender: String, alamat: String, password: String, password_confirmation:String)
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResult(responseUser: ResponseUser)
        fun showMessage(message: String)
    }
}