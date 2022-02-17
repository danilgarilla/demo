package com.example.demo.entity

import com.example.demo.enums.CountType
import javax.persistence.*


@Entity
@Table(name = "warehouse_product_hold")
data class WarehouseProductHoldEntity(

    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "product_id")
    val productId: Long,

    @Column(name = "warehouse_id")
    val warehouseId: Long,

    @Column(name = "count")
    val count: Double,

    @Enumerated(EnumType.STRING)
    @Column(name = "count_type")
    val countType: CountType

)
