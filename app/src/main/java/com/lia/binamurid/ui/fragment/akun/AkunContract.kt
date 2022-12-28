package com.lia.binamurid.ui.fragment.akun

import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.data.model.user.ResponseUserdetail

interface AkunContract {

    interface Presenter {
        fun doLogin(prefsManager: PrefsManager)
        fun doLogout(prefsManager: PrefsManager)

        fun profildetail(id:String)
    }

    interface View {
        fun initFragment(view: android.view.View)
        fun onResultLogin(prefsManager: PrefsManager)
        fun onResultLogout()
        fun onResult(responseUserdetail: ResponseUserdetail)
        fun showMessage(message: String)
    }

}