package com.example.androiddevchallenge.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.domain.repository.SolRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class SolViewModel : ViewModel()  {

    private val _state = MutableLiveData(SolViewState(latestSol = SolRepository.getLatestSol()))
    val viewState: LiveData<SolViewState> get() = _state

    init {
        val sols = SolRepository.getAvailableSols()
        _state.value = SolViewState(
            sols = sols,
            selectedSol = SolRepository.getLatestSol(),
            latestSol = SolRepository.getLatestSol()
        )
    }

    fun onSolNumberSelected(number: Int) {
        SolRepository.getSolByNumber(number)?.let {
            _state.value = _state.value?.copy(selectedSol = it)
        }
    }
}