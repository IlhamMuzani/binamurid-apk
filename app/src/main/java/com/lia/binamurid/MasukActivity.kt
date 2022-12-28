package com.lia.binamurid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lia.binamurid.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_masuk.*
import kotlinx.android.synthetic.main.toolbar.*

class MasukActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        fungsi()

        ivKembali.setOnClickListener {
            onBackPressed()
        }

        tv_nama.text = "Pilih Login"

    }

    fun fungsi(){
        layout_loginorangtua.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        layout_loginpendidik.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}