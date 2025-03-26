package com.packt.cardatabase.domain

import org.springframework.data.repository.CrudRepository


interface CarRepository : CrudRepository<Car, Long> {

}
