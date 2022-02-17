package com.example.demo.entity

import javax.persistence.*

@Entity
@Table(name = "warehouse")
data class WarehouseEntity(

    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "address")
    val address: String
)
