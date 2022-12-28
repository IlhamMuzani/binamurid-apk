package com.lia.binamurid.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lia.binamurid.R
import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.data.model.user.ResponseUser
import com.lia.binamurid.ui.fragment.UserActivity
import com.lia.binamurid.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    lateinit var presenter: LoginPresenter
    lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        prefsManager = PrefsManager(this)
    }

    override fun initActivity() {
    }

    override fun initListener() {

        btnLoginuser.setOnClickListener {
            presenter.doLogin(edit_textEmail.text.toString(), edit_textPassword.text.toString())
        }

        text_viewRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onLoading(loading: Boolean) {
        when(loading){
            true -> {
                progressbar.visibility = View.VISIBLE
                btnLoginuser.visibility = View.GONE
            }
            false -> {
                progressbar.visibility = View.GONE
                btnLoginuser.visibility = View.VISIBLE
            }
        }
    }

    override fun onResult(responseUser: ResponseUser) {
        if (responseUser.status == true){
            presenter.setPrefs(prefsManager, responseUser.user!!)
            startActivity(Intent(this, UserActivity::class.java))
        }else{

        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}