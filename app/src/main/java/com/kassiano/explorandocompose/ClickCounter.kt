package com.kassiano.explorandocompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun ClickCounter() {
    val state = remember {
        mutableStateOf(0)
    }

    Column {
        ClickText(state)
        ClickButton {
            state.value ++
        }
    }
}

@Composable
fun ClickText(state: MutableState<Int>) {
    Text(text = "Cliques: ${state.value}", fontSize = 30.sp)
}

@Composable
fun ClickButton(onClick: ()-> Unit) {
    Button(onClick) {
        Text(text = "Clique")
    }
}