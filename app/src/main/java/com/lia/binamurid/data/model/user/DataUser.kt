package com.lia.binamurid.data.model.user

import com.google.gson.annotations.SerializedName

class DataUser (
    @SerializedName( "id") val id: String?,
    @SerializedName( "nama") val nama: String?,
    @SerializedName( "email") val email: String?,
    @SerializedName("telp") val telp: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("alamat") val alamat: String?,
    @SerializedName("foto") val foto: String?,
    @SerializedName("role") val role: String?
)