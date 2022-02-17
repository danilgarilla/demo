package com.example.demo.repo

import com.example.demo.entity.ProductEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepo: CrudRepository<ProductEntity, Long> {
}