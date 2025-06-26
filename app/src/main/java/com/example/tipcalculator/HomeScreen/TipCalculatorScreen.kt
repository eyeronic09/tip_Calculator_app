package com.example.tipcalculator.HomeScreen

import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab.AlbumsTab.value
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipScreen(modifier: Modifier = Modifier , viewmodel: TipViewmodel) {
    val billAmount by viewmodel.BillAmount.collectAsState()
    val tipPercentage by viewmodel.TipPercentage.collectAsState()
    Scaffold(
        modifier = modifier,
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
                    .padding(paddingValues)
            ) {
                Card(modifier = Modifier.padding(20.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .fillMaxHeight(0.25f)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(1f)
                                .padding(20.dp)
                        ) {
                            Text(
                                text = "total per person",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 30.sp,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text(
                                text = billAmount,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 45.sp,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
                Card(
                    modifier = Modifier.padding(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                "Bill Amount",
                                color = Color.Gray
                            )
                            OutlinedTextField(
                                value = billAmount,
                                onValueChange = { viewmodel.userUpdateBill(it) },
                                modifier = Modifier.size(30.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(30.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                "Spilt",
                                color = Color.Gray
                            )
                            Row {
                                FilledTonalButton(
                                    onClick = {},
                                    modifier = Modifier.size(30.dp),
                                    shape = MaterialTheme.shapes.extraSmall
                                ) {
                                    Text("-")
                                }
                                Text("1")
                                FilledTonalButton(
                                    onClick = {},
                                    modifier = Modifier.size(30.dp),
                                    shape = MaterialTheme.shapes.extraSmall
                                ) {
                                    Text("-")
                                }
                            }
                        }

//                        Slider(
//                            value = tippers,
//                            onValueChange = { tippers = it },
//                            steps = 10,
//                            valueRange = 10f..100f,
//                            thumb = {
//
//                            }
//                        )
                    }
                }
            }
        }
    )
}
@Preview(showSystemUi = true)
@Composable
private fun tipPreview() {
    val viewmodel = TipViewmodel()
    TipScreen(viewmodel = viewmodel)
}