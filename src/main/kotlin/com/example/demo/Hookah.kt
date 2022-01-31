package com.example.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "hookah")
data class Hookah(

    @Id
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "address")
    val address: String

)
