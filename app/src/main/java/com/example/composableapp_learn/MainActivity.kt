package com.example.composableapp_learn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composableapp_learn.screens.GameScreen
import com.example.composableapp_learn.ui.theme.ComposableApp_LearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposableApp_LearnTheme {
                GameScreen()
            }
        }
    }
}

