package com.example.wammy.ui

import com.example.wammy.api.RetrofitClient
import com.example.wammy.utils.Webservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TodoRepository {

    var client: Webservice = RetrofitClient.retrofit

    @ExperimentalCoroutinesApi
    suspend fun getTodo() = client.getTodo()

    var myflow = flow {

        emit(getTodo())
    }
}