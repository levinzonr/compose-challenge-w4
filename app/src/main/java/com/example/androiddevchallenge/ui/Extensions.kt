package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import com.example.androiddevchallenge.R


@Composable fun Int.toDegreesString() : String {
    return stringResource(id = R.string.degrees_celsius, this.toString())
}

@Composable fun Int.toSolString() : String {
    return stringResource(id = R.string.sol, this.toString())
}