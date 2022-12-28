package com.lia.binamurid.ui.login

import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.data.model.user.DataUser
import com.lia.binamurid.data.model.user.ResponseUser

interface LoginContract {

    interface Presenter {
        fun doLogin(email:String, password:String)
        fun setPrefs(prefsManager: PrefsManager, dataUser: DataUser)
    }

    interface View {
        fun initActivity()
        fun initListener()
        fun onLoading(loading: Boolean)
        fun onResult(responseUser: ResponseUser)
        fun showMessage(message: String)
    }
}