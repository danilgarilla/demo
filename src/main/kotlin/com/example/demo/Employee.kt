package com.example.demo

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "employments")
data class Employee(

    @Id
    val id: Long = 0,

    @Column(name = "first_name")
    val firstName: String,

    @Column(name = "second_name")
    val secondName: String,

    @Column(name = "age")
    val age: Int
)
