package com.lia.binamurid.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.lia.binamurid.R
import com.lia.binamurid.data.model.user.ResponseUser
import com.lia.binamurid.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    lateinit var presenter: RegisterPresenter
    lateinit var telp: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        presenter = RegisterPresenter(this)
    }

    override fun initActivity() {
    }

    override fun initListener() {

        btnRegister.setOnClickListener {

            val radioID = radio_JK.checkedRadioButtonId
            val radiobutton = findViewById<RadioButton>(radioID)
            val gender = radiobutton.text

            if (edit_textNama.text!!.isEmpty()){
                edit_textNama.error = "Kolom Nama Tidak Boleh Kosong"
                edit_textNama.requestFocus()
            } else if (edit_textEmail.text!!.isEmpty()){
                edit_textEmail.error = "Kolom Email Tidak Boleh Kosong"
                edit_textEmail.requestFocus()
//            } else if (radio_JK){
//                showMessage("Pilih Gender")
//                radio_JK.requestFocus()
            } else if (edit_phone1.text!!.isEmpty()){
                edit_phone1.error = "Kolom Tidak Boleh Kosong"
                edit_phone1.requestFocus()
            } else if (edit_textALamat.text!!.isEmpty()){
                edit_textALamat.error = "Kolom ALamat Tidak Boleh Kosong"
                edit_textALamat.requestFocus()
            } else if (edit_textPassword.text!!.isEmpty()){
                edit_textPassword.error = "Kolom Tidak Boleh Kosong"
                edit_textPassword.requestFocus()
            } else if (edit_textKonfirmasiPassword.text!!.isEmpty()){
                edit_textKonfirmasiPassword.error = "Kolom Tidak Boleh Kosong"
                edit_textKonfirmasiPassword.requestFocus()
            } else
                presenter.insertregister(edit_textNama.text.toString(), edit_textEmail.text.toString(), edit_phone1.text.toString(), gender.toString(), edit_textALamat.text.toString(), edit_textPassword.text.toString(), edit_textKonfirmasiPassword.text.toString())
        }
    }

    override fun onLoading(loading: Boolean) {
        when (loading) {
            true -> {
                progresbarregis.visibility = View.VISIBLE
                btnRegister.visibility = View.GONE
            }
            false -> {
                progresbarregis.visibility = View.GONE
                btnRegister.visibility = View.VISIBLE
            }
        }
    }

    override fun onResult(responseUser: ResponseUser) {
        if (responseUser.status == true) {
//            responseUser.user
            showMessage(responseUser.message)
            startActivity(Intent(this, LoginActivity::class.java))
        }else{
            showMessage(responseUser.message)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}