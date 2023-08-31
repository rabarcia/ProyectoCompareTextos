package com.curso.android.app.practica.ejerciciofinal.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.ejerciciofinal.model.Comparador
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch



class MainViewModel : ViewModel() {
    val comparadorTextos: LiveData<Comparador> get() = _comparadorTextos
    private var _comparadorTextos = MutableLiveData<Comparador>()

    fun compareTextos(text1: String, text2: String) {
        val sonIguales = if (text2.isNotEmpty() && text1.isNotEmpty())
            text1 == text2 else false

        viewModelScope.launch {
            _comparadorTextos.value = Comparador(text1, text2, sonIguales)
        }
    }
}
