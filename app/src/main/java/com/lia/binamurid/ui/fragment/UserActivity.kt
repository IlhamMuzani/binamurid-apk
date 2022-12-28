package com.lia.binamurid.ui.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.lia.binamurid.MasukActivity
import com.lia.binamurid.R
import com.lia.binamurid.data.database.PrefsManager
import com.lia.binamurid.ui.fragment.akun.AkunFragment
import com.lia.binamurid.ui.fragment.daily_report.DailyreportFragment
import com.lia.binamurid.ui.fragment.history.HistoryFragment
import com.lia.binamurid.ui.fragment.home.HomeFragment

class UserActivity : AppCompatActivity() {
    val fragmentHome: Fragment = HomeFragment()
    val fragmentDailyreport: Fragment = DailyreportFragment()
    val fragmentHistory: Fragment = HistoryFragment()
    val fragmentAkun: Fragment = AkunFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    lateinit var menu: Menu
    lateinit var menuItem: MenuItem
    lateinit var bottomNavigationView: BottomNavigationView


    lateinit var prefsManager: PrefsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        setUpBottomNav()

        prefsManager = PrefsManager(this)
    }

    fun setUpBottomNav() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentDailyreport).hide(fragmentDailyreport).commit()
        fm.beginTransaction().add(R.id.container, fragmentHistory).hide(fragmentHistory).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        menuItem.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.navigation_home -> {
                    callFragment(0, fragmentHome)
                }

                R.id.navigation_dailyreport -> {
                    callFragment(1, fragmentDailyreport)
                }

                R.id.navigation_history -> {
                    callFragment(2, fragmentHistory)
                }

                R.id.navigation_akun -> {
                    if (prefsManager.prefIsLogin){

                        callFragment(3, fragmentAkun)
                    }
                    else {
                        startActivity(Intent(this, MasukActivity::class.java))
                    }
                }
            }
            false
        }
    }

    fun callFragment(int: Int, fragment: Fragment) {
        menuItem = menu.getItem(int)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (prefsManager.prefIsLogin) {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }
}