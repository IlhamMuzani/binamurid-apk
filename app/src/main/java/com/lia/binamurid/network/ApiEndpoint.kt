package com.anam.rentalmobil.network

import com.lia.binamurid.data.model.user.ResponseUser
import com.lia.binamurid.data.model.user.ResponseUserdetail
import retrofit2.Call
import retrofit2.http.*


interface ApiEndpoint {

    @FormUrlEncoded
    @POST("orangtua/register")
    fun register(
        @Field("nama") nama: String,
        @Field("email") email: String,
        @Field("telp") telp: String,
        @Field("gender") gender: String,
        @Field("alamat") alamat: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String,
//        @Field("fcm") fcm: String
    ): Call<ResponseUser>

    @FormUrlEncoded
    @POST("orangtua/login")
    fun loginorangtua(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Call<ResponseUser>

    @GET("orangtua/detail/{id}")
    fun ProfilDetail(
        @Path("id") id: String
    ) : Call<ResponseUserdetail>
}