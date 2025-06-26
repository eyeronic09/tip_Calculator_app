package com.example.tipcalculator.HomeScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TipViewmodel : ViewModel() {

    private val _BillAmount = MutableStateFlow("")
    val BillAmount: StateFlow<String> = _BillAmount

    private val _TipPercentage = MutableStateFlow(0.0)
    val TipPercentage: MutableStateFlow<Double> = _TipPercentage

    private val _TotalPerPerson = MutableStateFlow(0.0)
    val TotalPerPerson : MutableStateFlow<Double> = _TotalPerPerson

    fun userUpdateBill(newAmount: String){
        _BillAmount.value = newAmount
    }











}
@Preview(showSystemUi = true)
@Composable
private fun tipPreview() {
    val viewmodel = TipViewmodel()
    TipScreen(viewmodel = viewmodel)
}