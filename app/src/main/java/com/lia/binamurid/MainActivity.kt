package com.lia.binamurid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lia.binamurid.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        klik()
    }

    fun klik(){
        txv_klik.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}