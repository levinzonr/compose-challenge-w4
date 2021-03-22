package com.example.androiddevchallenge.ui.screens.home

import com.example.androiddevchallenge.domain.models.Sol

data class SolViewState(
    val sols: List<Sol> = listOf(),
    val selectedSol: Sol,
)