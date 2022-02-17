package com.example.demo.service

import com.example.demo.dto.BuyProductRequest
import com.example.demo.entity.ProductEntity
import com.example.demo.entity.WarehouseEntity
import com.example.demo.enums.CountType
import com.example.demo.repo.ProductRepo
import com.example.demo.repo.WarehouseLogbookRepo
import com.example.demo.repo.WarehouseProductHoldRepo
import com.example.demo.repo.WarehouseRepo
import org.checkerframework.checker.units.qual.A
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@SpringBootTest
@RunWith(SpringRunner::class)
class WarehouseLogbookServiceTest {

    @Autowired
    private lateinit var warehouseLogbookService: WarehouseLogbookService

    @Autowired
    private lateinit var productRepo: ProductRepo

    @Autowired
    private lateinit var warehouseRepo: WarehouseRepo

    @Autowired
    private lateinit var whProductHoldRepo: WarehouseProductHoldRepo

    @Autowired
    private lateinit var whProductLogbookRepo: WarehouseLogbookRepo

    private var productId: Long = 0
    private var whId: Long = 0

    @Before
    fun setUp() {
        val product = ProductEntity(
            name_text = "какаха",
            buy_price = 100,
            count_for_one = 100,
            count_type = CountType.GRAM
        ).let { productRepo.save(it) }

        productId = product.id!!

        val wh = WarehouseEntity(
            name = "Складище",
            address = "улица пушкина дом колотушкина"
        ).let { warehouseRepo.save(it) }

        whId = wh.id!!
    }

    @Test
    fun buyProductFirstHoldTest() {

        val buyDate = LocalDateTime.of(LocalDate.of(2020, 1,1), LocalTime.MIN)

        val request = BuyProductRequest(
            productId = productId,
            warehouseId = whId,
            count = 20.0,
            buyTime = buyDate
        )

        warehouseLogbookService.buyProducts(request)

        val whProductLogbook =
            whProductLogbookRepo.findByWarehouseIdAndProductId(request.warehouseId, request.productId)


        assert(20.0 == whProductLogbook.count)
        assert(buyDate == whProductLogbook.transactionTime)
    }
}