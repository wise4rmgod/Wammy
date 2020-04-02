package com.example.wammy.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.wammy.model.Todou
import kotlinx.coroutines.Dispatchers

class TodoViewmodel : ViewModel() {
    val repository: TodoRepository = TodoRepository()

    val firstTodo: LiveData<Todou> = liveData(Dispatchers.IO) {
        val retrivedTodo = repository.getTodo()
        emit(retrivedTodo)
    }

}