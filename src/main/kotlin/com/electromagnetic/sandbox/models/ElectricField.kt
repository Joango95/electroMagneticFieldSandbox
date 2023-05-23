package com.electromagnetic.sandbox.models

data class ElectricField(
    val fieldMagnitude: List<List<PositionMagnitude>>,
    val originCharge: Charge,
)