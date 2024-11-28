package com.example.vazamento_de_dados_api

data class LeakResponse(
    val success: Boolean,
    val found: Int,
    val fields: List<String>,
    val sources: List<Source>
)

data class Source(
    val name: String,
    val date: String
)
