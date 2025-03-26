package com.packt.cardatabase.web

import com.packt.cardatabase.domain.Owner
import com.packt.cardatabase.domain.OwnerInput
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
class OwnerController @Autowired constructor(
    private val ownerRepository: OwnerRepository
) {
    @GetMapping("/owners")
    fun getOwners(): List<Owner> = ownerRepository.findAll().toList()
    
    @PostMapping("/owners")
    fun addOwner(@Valid @RequestBody ownerInput: OwnerInput):
            ResponseEntity<String> = ownerInput
                .toOwner()
                .let { owner -> ownerRepository.save(owner).let {
                    ResponseEntity.status(HttpStatus.ACCEPTED)
                        .header("Location", "/owners/${it.ownerid}")
                        .build()
                }}
    
    @GetMapping("/owners/{id}")
    fun getOwner(@PathVariable id: Long): Owner = 
        ownerRepository.findById(id).orElse(null)
}