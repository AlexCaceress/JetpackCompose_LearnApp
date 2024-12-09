package com.example.composableapp_learn.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun ResultDialog(
    hideDialog: () -> Unit, // Unit == Void
    onRoundIncrement : () -> Unit,
    titleDialog : Int,
    sliderValue : Int,
    points : Int
) {
    AlertDialog(
        onDismissRequest = {
            hideDialog()
            onRoundIncrement()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    hideDialog()
                    onRoundIncrement()
                }
            ) {
                Text("This is an Alert")
            }
        },
        title = { Text(stringResource(id = titleDialog)) },
        text = { Text("Slider value $sliderValue and User Points $points") }

    )
}