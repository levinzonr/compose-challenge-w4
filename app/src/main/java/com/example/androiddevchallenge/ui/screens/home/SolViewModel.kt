/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.domain.repository.SolRepository

class SolViewModel : ViewModel() {

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
