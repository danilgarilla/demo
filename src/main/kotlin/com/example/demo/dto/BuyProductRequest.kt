package com.example.demo.dto

import java.time.LocalDateTime

data class BuyProductRequest(
    val productId: Long,
    val warehouseId: Long,
    val count:Double,
    val buyTime: LocalDateTime
)
