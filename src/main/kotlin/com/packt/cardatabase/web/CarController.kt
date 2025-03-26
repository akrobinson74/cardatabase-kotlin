package com.packt.cardatabase.web

import com.packt.cardatabase.domain.Car
import com.packt.cardatabase.domain.CarInput
import com.packt.cardatabase.domain.CarRepository
import com.packt.cardatabase.domain.OwnerRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CarController @Autowired constructor(
    private val carRepository: CarRepository,
    private val ownerRepository: OwnerRepository
) {

    @GetMapping("/cars")
    fun getCars(): List<Car> = carRepository.findAll().toList()
    
    @GetMapping("/cars/{id}")
    fun getCar(@PathVariable id: Long): Car = carRepository.findById(id).orElse(null)
    
    @PostMapping("/cars")
    fun addCar(@Valid @RequestBody carInput: CarInput): ResponseEntity<Car> = carInput
        .toCar(ownerRepository)
        .let {
            carRepository.save(it).let {
                ResponseEntity.status(HttpStatus.ACCEPTED)
                    .header("Location", "/cars/${it.id}")
                    .body(it)
            }
        }
}