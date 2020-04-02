package com.example.wammy.ui

import com.example.wammy.api.RetrofitClient
import com.example.wammy.utils.Webservice

class TodoRepository {

    var client: Webservice = RetrofitClient.retrofit

    suspend fun getTodo() = client.getTodo()
}