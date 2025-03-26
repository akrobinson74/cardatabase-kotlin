package com.packt.cardatabase.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator
import jakarta.validation.constraints.NotEmpty

@Entity
@JsonIgnoreProperties("hibernateLazyInitializer", "handler")
class Owner(
    var firstname: String,
    @field:NotEmpty(message="'lastname' must be specified")
    var lastname: String,
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_sequence")
    @SequenceGenerator(name = "owner_sequence", allocationSize = 1)
    var ownerid: Long?
) {
}
