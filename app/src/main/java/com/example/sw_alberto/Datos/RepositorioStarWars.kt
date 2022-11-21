package com.example.sw_alberto.Datos

data class RepositorioStarWars(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)