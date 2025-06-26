package com.example.tipcalculator.HomeScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TipViewmodel : ViewModel() {

    private val _BillAmount = MutableStateFlow("")
    val BillAmount: StateFlow<String> = _BillAmount

    private val _TipPercentage = MutableStateFlow(10f)
    val TipPercentage: StateFlow<Float> = _TipPercentage

    private val _TotalPerPerson = MutableStateFlow(0.0)
    val TotalPerPerson : StateFlow<Double> = _TotalPerPerson

    fun userUpdateBill(newAmount: String){
        _BillAmount.value = newAmount
        calculateTip()
    }
    fun updateTipPercentage(newPercentage: Float) {
        _TipPercentage.value = newPercentage
        calculateTip()
    }
private fun calculateTip() {
    val bill = BillAmount.value.toDoubleOrNull() ?: 0.0
    val tip = bill * (_TipPercentage.value / 100)
    val total = bill + tip
    _TotalPerPerson.value = total
}


}
@Preview(showSystemUi = true)
@Composable
private fun tipPreview() {
    val viewmodel = TipViewmodel()
    TipScreen(viewmodel = viewmodel)
}