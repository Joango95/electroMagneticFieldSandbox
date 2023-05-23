package com.electromagnetic.sandbox.generator

import com.electromagnetic.sandbox.models.*
import com.example.demo.models.*
import org.springframework.stereotype.Service

@Service
class FieldGenerator {

    companion object {
        const val COULOMB_CONSTANT = 1.0

        fun characterGenerator(numberToConvert: Double): String {
            return when {
                numberToConvert >= 10.0 -> "@ "
                numberToConvert in 8.0..10.0 -> "# "
                numberToConvert in 7.0..8.0 -> "% "
                numberToConvert in 6.0..7.0 -> "1 "
                numberToConvert in 5.0..6.0 -> "a "
                numberToConvert in 4.0..5.0 -> "* "
                numberToConvert in 3.0..4.0 -> "= "
                numberToConvert in 2.0..3.0 -> ": "
                else -> ". "
            }
        }
    }


    fun generateField (
        charge: Charge,
        grid: Grid
    ): ElectricField {
        val magnitudeMatrix = (1..grid.rows).map { row ->
            (1..grid.columns).map { column ->

                val xResulting = column - charge.position.posX.toDouble()
                val yResulting = row - charge.position.posY.toDouble()
                val squaredDistance = (xResulting * xResulting) + (yResulting * yResulting)

                val resultingMagnitude = Magnitude(COULOMB_CONSTANT * charge.value / squaredDistance)

                PositionMagnitude(
                    Position(
                        column,
                        row
                    ),
                    resultingMagnitude
                )
            }
        }

        return ElectricField (
            fieldMagnitude = magnitudeMatrix,
            originCharge = charge
        )
    }

}
