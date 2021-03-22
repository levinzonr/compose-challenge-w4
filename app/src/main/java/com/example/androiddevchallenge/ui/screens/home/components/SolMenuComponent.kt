package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.domain.extensions.format
import com.example.androiddevchallenge.domain.models.Pressure
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.marsLight
import com.example.androiddevchallenge.ui.toSolString
import java.util.*

@Composable
fun SolMenuComponent(
    items: List<Sol>,
    modifier: Modifier = Modifier,
    current: Int = 0,
    onSolNumberSelected: (Int) -> Unit
) {

    if (items.isNotEmpty()) {
        val next = items.find { it.number == current.inc() }
        val previous = items.find { it.number == current.dec() }
        ConstraintLayout(
            modifier = modifier.fillMaxWidth()
        ) {

            val (firstRef, currentRef, nextRef, dateRef) = createRefs()

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

            val dateConstrain = Modifier.constrainAs(dateRef) {
                top.linkTo(currentRef.bottom)
                start.linkTo(currentRef.start)
                end.linkTo(currentRef.end)
            }

            val nextConstraint = Modifier.constrainAs(nextRef) {
                bottom.linkTo(parent.bottom)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            }

            previous?.let {
                SolHeader(
                    sol = it,
                    active = false,
                    modifier = firstConstraint.clickable {
                        onSolNumberSelected.invoke(it.number)
                    })
            }


            SolHeader(
                sol = items.first { it.number == current },
                active = true,
                modifier = currentConstraint
            )

            Text(
                text = items.first { it.number == current }.date.format(),
                modifier = dateConstrain,
                color = marsLight,
                style = MaterialTheme.typography.subtitle1
            )

            next?.let {
                SolHeader(
                    sol = it,
                    active = false,
                    modifier = nextConstraint.clickable {
                        onSolNumberSelected.invoke(it.number)
                    })
            }
        }
    }

}

@Composable
fun SolHeader(sol: Sol, active: Boolean, modifier: Modifier = Modifier) {
    Text(
        text = sol.number.toSolString(),
        color = if (active) Color.White else marsLight,
        style = if (active) MaterialTheme.typography.h1 else MaterialTheme.typography.h2,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewSolMenuComponent() {
    MyTheme {
        SolMenuComponent(items = List(10) {
            Sol(
                it + 1000,
                Date(),
                com.example.androiddevchallenge.domain.models.SolTemperature(0, 0),
                Pressure(100, ""),
                "",
                "",
                "",
                ""
            )
        }) {

        }
    }
}