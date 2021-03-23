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
package com.example.androiddevchallenge.ui.screens.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.domain.extensions.format
import com.example.androiddevchallenge.domain.extensions.nextAfter
import com.example.androiddevchallenge.domain.extensions.previousBefore
import com.example.androiddevchallenge.domain.models.Sol
import com.example.androiddevchallenge.domain.repository.SolRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.toSolString

sealed class SolPage(val id: Int) {
    object Forecast : SolPage(-1)
    data class SolHeader(val sol: Sol) : SolPage(sol.number)
}

@Composable
fun SolMenuComponent(
    items: List<SolPage>,
    current: SolPage?,
    modifier: Modifier = Modifier,
    onSolNumberSelected: (Int) -> Unit = {}
) {

    if (items.isNotEmpty() && current != null) {
        val next = items.nextAfter(current)
        val previous = items.previousBefore(current)
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
                SolMenuModel(
                    model = it,
                    active = false,
                    modifier = firstConstraint.clickable {
                        onSolNumberSelected.invoke(it.id)
                    }
                )
            }

            SolMenuModel(
                model = items.first { it == current },
                active = true,
                modifier = currentConstraint
            )

            if (current is SolPage.SolHeader) {
                Text(
                    text = current.sol.date.format(),
                    modifier = dateConstrain,
                    color = MaterialTheme.colors.secondary,
                    style = MaterialTheme.typography.subtitle1
                )
            }

            next?.let {
                SolMenuModel(
                    model = it,
                    active = false,
                    modifier = nextConstraint.clickable {
                        onSolNumberSelected.invoke(it.id)
                    }
                )
            }
        }
    }
}

@Composable
fun SolMenuModel(model: SolPage, active: Boolean, modifier: Modifier = Modifier) {
    val text = when (model) {
        is SolPage.Forecast -> "Forecast"
        is SolPage.SolHeader -> model.sol.number.toSolString()
    }
    Text(
        text = text,
        color = if (active) MaterialTheme.colors.primary else MaterialTheme.colors.secondary,
        style = if (active) MaterialTheme.typography.h1 else MaterialTheme.typography.h2,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewSolMenuComponent() {
    val items = SolRepository.getAvailableSols()
    MyTheme {
        SolMenuComponent(items = items.map { SolPage.SolHeader(it) }, current = SolPage.SolHeader(items.last()))
    }
}
