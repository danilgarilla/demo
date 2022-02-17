package com.example.demo.repo

import com.example.demo.entity.WarehouseEntity
import com.example.demo.entity.WarehouseProductHoldEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WarehouseRepo : CrudRepository<WarehouseEntity, Long> {

}