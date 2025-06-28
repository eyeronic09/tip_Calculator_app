package com.example.tipcalculator.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipScreen(viewmodel: TipViewmodel) {
    val billAmount by viewmodel.BillAmount.collectAsState()
    val tipPercentage by viewmodel.TipPercentage.collectAsState()
    val PerPerson by viewmodel.TotalPerPerson.collectAsState()
    val split by viewmodel.spiltCounter.collectAsState()
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {

            }
        },
        modifier = Modifier,
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
                                text = "$${"%.2f".format(PerPerson)}",
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

                    Column() {
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
                                modifier = Modifier.size(110.dp, 35.dp),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                            Row() {
                                IconButton(
                                    onClick = { viewmodel.incrementSpilt() },
                                    modifier = Modifier.size(40.dp),
                                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),

                                    ) {
                                    Icon(
                                        imageVector = Icons.Filled.KeyboardArrowUp,
                                        contentDescription = "Increase"
                                    )
                                }

                                Text(
                                    text = "$split",
                                    modifier = Modifier.padding(10.dp)
                                        .width(40.dp)
                                        .height(
                                            40.dp
                                        ),
                                    textAlign = TextAlign.Center,
                                )
                                IconButton(
                                    onClick = { viewmodel.decrementSpilt() },
                                    modifier = Modifier.size(40.dp),
                                    colors = IconButtonDefaults.iconButtonColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.KeyboardArrowDown,
                                        contentDescription = "Increase"
                                    )
                                }
                            }

                        }
                        Row(
                            modifier = Modifier.padding(30.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalAlignment = Alignment.CenterVertically){
                            Button(onClick = {}, shape = RectangleShape) {
                                Text("10%")
                            }
                            Button(onClick = {}, shape = RectangleShape , modifier = Modifier.size(40.dp)) {
                                Text("15%")
                            }
                            Button(onClick = {}, shape = RectangleShape) {
                                Text("20%")
                            }
                            Button(onClick = {}, shape = RectangleShape,) {
                                Text("20%")
                            }
                        }


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