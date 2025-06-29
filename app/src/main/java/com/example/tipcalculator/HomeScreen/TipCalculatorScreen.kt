package com.example.tipcalculator.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipScreen(viewmodel: TipViewmodel) {
    val billAmount by viewmodel.BillAmount.collectAsStateWithLifecycle()
    val perPerson by viewmodel.TotalPerPerson.collectAsStateWithLifecycle()
    val split by viewmodel.spiltCounter.collectAsStateWithLifecycle()
    Scaffold(
        modifier = Modifier
            .systemBarsPadding(),
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)

            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .background(
                            CardDefaults.cardColors().containerColor,
                            shape = CardDefaults.shape
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "Total per person",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "$${"%.2f".format(perPerson)}",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 45.sp,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(30.dp))

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
                            Row{
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
                                    modifier = Modifier
                                        .padding(10.dp)
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
                    }
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)) {
                    Spacer(Modifier.height(30.dp))
                    Text(
                        text = "Select tip percentage",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Row(modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.spacedBy(30.dp)
                        ) {

                        Button(
                            onClick = { viewmodel.UpdateTipPercentage(10.0) },
                            shape = RectangleShape
                        ) {
                            Text("10%")

                        }
                        Button(
                            onClick = {  viewmodel.UpdateTipPercentage(15.0)},
                            shape = RectangleShape
                        ) {
                            Text("15%")

                        }
                        Button(
                            onClick = {  viewmodel.UpdateTipPercentage(20.0) },
                            shape = RectangleShape
                        ) {
                            Text("20%")

                        }
                    }
                }
            }

        }
    )
}
