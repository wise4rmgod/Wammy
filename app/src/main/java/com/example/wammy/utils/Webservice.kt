package com.example.wammy.utils

import com.example.wammy.model.Todou
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface Webservice {
    @GET("/posts")
   suspend fun getTodo(): Todou
}