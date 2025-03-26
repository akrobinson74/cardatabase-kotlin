package com.packt.cardatabase.domain

import org.springframework.data.repository.CrudRepository

interface OwnerRepository : CrudRepository<Owner, Long> {
}