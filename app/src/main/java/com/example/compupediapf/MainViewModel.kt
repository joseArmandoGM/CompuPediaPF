package com.example.compupediapf

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compupediapf.data.Datasource
import com.example.compupediapf.model.CartasComponentes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class MainViewModel : ViewModel() {

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _componentes = MutableStateFlow(Datasource().loadComponentes())
    val componentes = searchText
        .combine(_componentes) { text, componentes ->
            if (text.isBlank()) {
                componentes
            } else {
                componentes.filter {
                    it.doesMatchSearchQuery(text)
                }
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _componentes.value
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}