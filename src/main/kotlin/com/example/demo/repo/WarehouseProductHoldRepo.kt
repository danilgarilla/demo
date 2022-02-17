package com.example.demo.repo

import com.example.demo.entity.WarehouseProductHoldEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseProductHoldRepo : CrudRepository<WarehouseProductHoldEntity, Long> {

    fun findByWarehouseIdAndProductId(warehouseId: Long, productId: Long): WarehouseProductHoldEntity?
}