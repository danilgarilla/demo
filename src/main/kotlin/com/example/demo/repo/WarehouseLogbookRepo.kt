package com.example.demo.repo

import com.example.demo.entity.WarehouseLogbookEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseLogbookRepo : CrudRepository<WarehouseLogbookEntity, Long> {
    fun findByWarehouseIdAndProductId(warehouseId: Long, productId: Long): WarehouseLogbookEntity
}