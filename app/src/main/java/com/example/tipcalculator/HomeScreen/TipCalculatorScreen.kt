package com.example.tipcalculator.HomeScreen

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TipScreen(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        Card(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(0.25f)) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
                    .padding(20.dp)) {
                    Text(
                        text = "total per person",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Text(
                        "$39.0",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 45.sp,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

            }
        }

    }
}
@Preview(showSystemUi = true)
@Composable
private fun tipPreview() {
    TipScreen()
}