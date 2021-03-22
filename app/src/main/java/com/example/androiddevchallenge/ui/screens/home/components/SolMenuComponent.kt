package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.marsLight

@Composable
fun SolMenuComponent(items: List<String>, modifier: Modifier = Modifier) {
    val state = remember { mutableStateOf(items.count() - 1) }
    val next = items.getOrNull(state.value.inc())
    val previous = items.getOrNull(state.value.dec())

    ConstraintLayout(
        modifier = modifier.fillMaxWidth()
    ) {

        val (firstRef, currentRef, nextRef) = createRefs()

        val firstConstraint = Modifier.constrainAs(firstRef) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }

        val currentConstraint = Modifier.constrainAs(currentRef) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }


        val nextConstraint = Modifier.constrainAs(nextRef) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }

        Text(
            text = previous ?: "",
            color = marsLight,
            style = MaterialTheme.typography.h2,
            modifier = firstConstraint.clickable {
                previous?.let { state.value = items.indexOf(it) }
            })
        Text(
            text = items[state.value],
            style = MaterialTheme.typography.h1,
            modifier = currentConstraint
        )
        Text(text = next ?: "",
            color = marsLight,
            style = MaterialTheme.typography.h2, modifier = nextConstraint.clickable {
                next?.let { state.value = items.indexOf(it) }
            })
    }

}

@Preview
@Composable
fun PreviewSolMenuComponent() {
    MyTheme {
        SolMenuComponent(List(10) { "SOL 111$it" })
    }
}