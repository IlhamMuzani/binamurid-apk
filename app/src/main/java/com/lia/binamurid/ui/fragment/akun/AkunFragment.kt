package com.lia.binamurid.ui.fragment.akun

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.datatransport.runtime.dagger.MapKey
import com.lia.binamurid.R
import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.data.model.user.ResponseUserdetail
import com.lia.binamurid.ui.fragment.UserActivity

class AkunFragment : Fragment(), AkunContract.View {

    lateinit var prefsManager: PrefsManager
    lateinit var presenter: AkunPresenter

    lateinit var txvNama : TextView
    lateinit var txvEmail : TextView
    lateinit var linlogout : LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_akun, container, false)

        initFragment(view)
        prefsManager = PrefsManager(requireActivity())
        presenter = AkunPresenter(this)
        presenter.doLogin(prefsManager)

        return view
    }

    override fun onStart() {
        super.onStart()
        presenter.profildetail(prefsManager.prefsId)

    }

    override fun initFragment(view: View) {
        txvNama = view.findViewById(R.id.txv_nama)
        txvEmail = view.findViewById(R.id.txv_email)
        linlogout = view.findViewById(R.id.linelogout)

        linlogout.setOnClickListener {
            presenter.doLogout(prefsManager)
        }

    }

    override fun onResultLogin(prefsManager: PrefsManager) {
    }

    override fun onResultLogout() {
        startActivity(Intent(requireActivity(), UserActivity::class.java))
    }

    override fun onResult(responseUserdetail: ResponseUserdetail) {
        val akun = responseUserdetail.user
        txvNama.setText(akun!!.nama)
        txvEmail.setText(akun!!.email)
    }

    override fun showMessage(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }
}