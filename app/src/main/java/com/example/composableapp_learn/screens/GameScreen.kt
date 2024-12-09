package com.example.composableapp_learn.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composableapp_learn.R
import com.example.composableapp_learn.components.GameDetail
import com.example.composableapp_learn.components.GamePrompt
import com.example.composableapp_learn.components.ResultDialog
import com.example.composableapp_learn.components.TargetSlider
import com.example.composableapp_learn.ui.theme.ComposableApp_LearnTheme
import kotlin.math.abs
import kotlin.random.Random

@Composable
fun GameScreen() {

    fun newTargetValue() = Random.nextInt(1, 100)

    var alertIsVisible by rememberSaveable { mutableStateOf(false) }
    var sliderValue by rememberSaveable { mutableStateOf(0.0f) }
    var targetValue by remember { mutableStateOf(newTargetValue()) }
    var totalScreen by rememberSaveable { mutableStateOf(0) }
    var currentRound by rememberSaveable { mutableStateOf(1) }

    val sliderToInt = (sliderValue * 100).toInt()

    fun differenceAmount() = abs(targetValue - sliderToInt)


    fun userPoints() : Int {

        val difference = differenceAmount()
        val points : Int = if(difference < 0){
            difference * -1
        }else{
            difference
        }

        return points

    }

    fun alertTitle() : Int {

        val difference = differenceAmount()

        val title : Int = if(difference == 0){
            R.string.alert_title_1
        }else if(difference < 5){
            R.string.alert_title_2
        }else if(difference <= 10){
            R.string.alert_title_3
        }else{
            R.string.alert_title_4
        }

        return title
    }

    fun startNewGame() {

        totalScreen = 0
        currentRound = 1
        sliderValue = 0.5f
        targetValue = newTargetValue()

    }

    val hideDialog = {
        alertIsVisible = false
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.weight(.5f))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(9f)
        ) {
            GamePrompt(
                sliderValue = targetValue
            )
            TargetSlider(
                value = sliderValue,
                valueChanged = { value ->
                    sliderValue = value
                }
            )
            Button(onClick = {
                totalScreen += totalScreen + userPoints()
                alertIsVisible = true
            },
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(16.dp)
            ) {
                Text("Hit me")
            }
            GameDetail(
                totalScore = totalScreen,
                gameRound = currentRound,
                modifier = Modifier.fillMaxWidth(),
                onStartOver = {startNewGame()}
            )
        }
        Spacer(modifier = Modifier.weight(.5f))

        if (alertIsVisible) {
            ResultDialog(
                hideDialog = hideDialog,
                titleDialog = alertTitle(),
                sliderValue = sliderToInt,
                points = userPoints(),
                onRoundIncrement = {
                    currentRound += 1
                    targetValue = newTargetValue()
                }
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.AUTOMOTIVE_1024p, widthDp = 864, heightDp = 432)
@Composable
fun GreetingPreview() {
    ComposableApp_LearnTheme {
        GameScreen()
    }
}