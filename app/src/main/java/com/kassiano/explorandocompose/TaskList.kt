package com.kassiano.explorandocompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp

data class TaskListState(
    val textFieldValue: MutableState<TextFieldValue>,
    val tasks: MutableState<List<String>>
)

@Composable
fun TaskList() {

    val state = remember {
        TaskListState(
            mutableStateOf(TextFieldValue()),
            mutableStateOf(emptyList())
        )
    }

    Column {
        NewTaskComponent(state)
        TaskListComponent(state)
    }
}

@Composable
fun NewTaskComponent(state: TaskListState) {
    Row {
        TextField(value = state.textFieldValue.value, onValueChange = {
            state.textFieldValue.value = it
        })
        
        Button(onClick = {
            state.tasks.value += state.textFieldValue.value.text
        }) {
            Text(text = "Adicionar")
        }
    }
}

@Composable
fun TaskListComponent(state: TaskListState) {
    state.tasks.value.forEach {
        Text(text = it, fontSize = 24.sp)
    }
}