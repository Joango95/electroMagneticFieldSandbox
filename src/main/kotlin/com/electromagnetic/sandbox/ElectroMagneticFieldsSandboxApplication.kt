package com.electromagnetic.sandbox

import com.electromagnetic.sandbox.generator.FieldGenerator
import com.electromagnetic.sandbox.generator.FieldGenerator.Companion.characterGenerator
import com.electromagnetic.sandbox.models.Charge
import com.electromagnetic.sandbox.models.Grid
import com.electromagnetic.sandbox.models.Position
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElectroMagneticFieldsSandboxApplication

fun main(args: Array<String>) {
	runApplication<ElectroMagneticFieldsSandboxApplication>(*args)
	val fieldGenerator = FieldGenerator()
	val grid = Grid(
		100,
		100
	)
	val charge = Charge(
		2000.0,
		Position(
			50,
			50
		)
	)
	val field = fieldGenerator.generateField(
		charge,
		grid
	)

	field.fieldMagnitude.forEach { row ->
		row.forEach { column ->
			print(characterGenerator(column.magnitude.value))
		}
		println()
	}
}

