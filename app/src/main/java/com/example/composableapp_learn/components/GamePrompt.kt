package com.example.composableapp_learn.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun GamePrompt(modifier: Modifier = Modifier, sliderValue : Int = 0) {
    Text("KELOKEEEEEEEEEEE",
        style = MaterialTheme.typography.titleMedium.copy(letterSpacing = 1.sp, fontWeight = FontWeight.Bold)
    )
    Text(sliderValue.toString(),
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(showBackground = true)
@Composable
private fun GamePromptPreview() {
    GamePrompt(sliderValue = 50)
}