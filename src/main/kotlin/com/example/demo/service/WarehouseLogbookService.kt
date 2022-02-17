package com.example.demo.service

import com.example.demo.dto.BuyProductRequest
import com.example.demo.entity.WarehouseLogbookEntity
import com.example.demo.entity.WarehouseProductHoldEntity
import com.example.demo.repo.ProductRepo
import com.example.demo.repo.WarehouseLogbookRepo
import com.example.demo.repo.WarehouseProductHoldRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class WarehouseLogbookService(
    private val warehouseLogbookRepo: WarehouseLogbookRepo,
    private val warehouseProductHoldRepo: WarehouseProductHoldRepo,
    private val productRepo: ProductRepo
) {

    @Transactional
    fun buyProducts(buyProductRequest: BuyProductRequest) {
        val product = productRepo.findByIdOrNull(buyProductRequest.productId)!!

        WarehouseLogbookEntity(
            productId = product.id!!,
            warehouseId = buyProductRequest.warehouseId,
            count = buyProductRequest.count,
            transactionTime = buyProductRequest.buyTime
        ).let { warehouseLogbookRepo.save(it) }


        (warehouseProductHoldRepo.findByWarehouseIdAndProductId(
            productId = product.id,
            warehouseId = buyProductRequest.warehouseId
        )?.let {
            it.copy(
                count = it.count + buyProductRequest.count
            )
        } ?: WarehouseProductHoldEntity(
            productId = product.id,
            warehouseId = buyProductRequest.warehouseId,
            count = buyProductRequest.count,
            countType = product.count_type
        )).let {
            warehouseProductHoldRepo.save(it)
        }

    }

}