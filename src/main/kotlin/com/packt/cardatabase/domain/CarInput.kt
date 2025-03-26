package com.packt.cardatabase.domain

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotEmpty

data class CarInput(
    @field:NotEmpty(message = "brand is required")
    val brand: String,
    @field:NotEmpty(message = "color is required")
    val color: String,
    @field:NotEmpty(message = "model is required")
    val model: String,
    @field:Min(value = 1908, message = "Ford Model T or later")
    @field:Max(value = 2026, message = "No models new than 2026 :(")
    val modelYear: Integer,
    @field:Min(value = 0, message = "Only positive integer values")
    val price: Integer,
    @field:NotEmpty(message = "registrationNumber is required")
    val registrationNumber: String,
    val ownerId: Long?
) {
    fun toCar(ownerRepository: OwnerRepository): Car = Car(
        brand = this.brand,
        color = this.color,
        model = this.model,
        modelYear = this.modelYear,
        price = this.price,
        registrationNumber = this.registrationNumber,
        owner = ownerRepository.findById(this.ownerId ?: -1).orElse(null),
        id = null
    )
}