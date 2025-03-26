package com.packt.cardatabase.domain

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator

@Entity
class Car(
    var brand: String,
    var color: String,
    var model: String,
    var modelYear: Integer,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    var owner: Owner,
    var price: Integer,
    var registrationNumber: String,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_sequence")
    @SequenceGenerator(name = "car_sequence", allocationSize = 1)
    var id: Long?)
