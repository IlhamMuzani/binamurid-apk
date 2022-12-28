package com.lia.binamurid.data.database

import android.content.Context
import android.content.SharedPreferences
import hu.autsoft.krate.Krate
import hu.autsoft.krate.booleanPref
import hu.autsoft.krate.stringPref

class PrefsManager(context: Context) : Krate {

    private val PREFS_IS_LOGIN: String = "prefs_is_login"
    private val PREFS_ID: String = "prefs_id"
    private val PREFS_IS_NAMA: String = "prefs_is_nama"
    private val PREFS_IS_EMAIL: String = "prefs_is_email"
    private val PREFS_IS_TELP: String = "prefs_is_telp"
    private val PREFS_IS_ALAMAT: String = "prefs_is_alamat"
    private val PREFS_IS_GENDER: String = "prefs_is_GENDER"
    private val PREFS_IS_PASSWORD: String = "prefs_is_password"
    private val PREFS_IS_PASSWORD_CONFIRMATION: String = "prefs_is_password_confirmation"


    override val sharedPreferences: SharedPreferences

    init {
        sharedPreferences =context.applicationContext.getSharedPreferences(
            "RentalMobil",Context.MODE_PRIVATE
        )
    }

    var prefIsLogin by booleanPref(PREFS_IS_LOGIN, false)
    var prefsId by stringPref(PREFS_ID, "")
    var prefs_is_nama by stringPref(PREFS_IS_NAMA, "")
    var prefs_is_email by stringPref(PREFS_IS_EMAIL, "")
    var prefs_is_telp by stringPref(PREFS_IS_TELP, "")
    var prefs_is_alamat by stringPref(PREFS_IS_ALAMAT, "")
    var prefs_is_gender by stringPref(PREFS_IS_GENDER, "")
    var prefs_is_password by stringPref(PREFS_IS_PASSWORD, "")
    var prefs_is_password_confirmation by stringPref(PREFS_IS_PASSWORD_CONFIRMATION, "")

    fun logout(){
        sharedPreferences.edit().clear().apply()
    }
}