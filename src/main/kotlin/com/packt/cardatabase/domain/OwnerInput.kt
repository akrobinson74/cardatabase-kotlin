package com.packt.cardatabase.domain

import jakarta.validation.constraints.NotEmpty

data class OwnerInput(
    @field:NotEmpty(message="'firstname' must be specified")
    val firstname: String,
    @field:NotEmpty(message="'lastname' must be specified")
    val lastname: String
) {
    fun toOwner(): Owner = run { 
        Owner(
            firstname = this.firstname,
            lastname = this.lastname,
            ownerid = null
        )
    }
}
