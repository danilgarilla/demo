package com.example.demo.entity

import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "warehouse_logbook")
data class WarehouseLogbookEntity (

    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "warehouse_id")
    val warehouseId: Long,

    @Column(name = "count")
    val count: Double,

    @Column(name = "transaction_time")
    val transactionTime: LocalDateTime
    )