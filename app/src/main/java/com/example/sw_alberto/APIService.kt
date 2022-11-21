package com.example.sw_alberto

import com.example.sw_alberto.Datos.RepositorioStarWars
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getPersonaje(@Url url:String): Response<RepositorioStarWars>
}