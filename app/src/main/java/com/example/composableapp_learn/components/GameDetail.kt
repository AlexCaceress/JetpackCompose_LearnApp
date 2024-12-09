package com.example.composableapp_learn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GameDetail(
    modifier: Modifier = Modifier,
    totalScore: Int = 0,
    gameRound: Int = 0,
    onStartOver: () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        FilledIconButton(
            onClick = {onStartOver()},
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                Icons.Filled.Refresh,
                contentDescription = "Restart Button"
            )
        }

        GameInfo(label = "Value", value = totalScore)
        GameInfo(label = "Round", value = gameRound)

        FilledIconButton(
            onClick = {},
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = MaterialTheme.colorScheme.tertiary
            ),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                Icons.Filled.Info,
                contentDescription = "Info Button"
            )
        }
    }
}

@Composable
fun GameInfo(label: String, value: Int = 0) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 32.dp)
    ) {
        Text(label)
        Text(value.toString())
    }
}

@Preview(showBackground = true)
@Composable
private fun GameDetailPreview() {
    GameDetail(onStartOver = {})
}