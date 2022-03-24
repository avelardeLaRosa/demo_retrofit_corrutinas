package com.system.demo_retrofit

import com.system.demo_retrofit.entidades.entidades.Usuario
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {

    @GET("posts/")
    suspend fun getUsuarioPost():Response<List<Usuario>>
}