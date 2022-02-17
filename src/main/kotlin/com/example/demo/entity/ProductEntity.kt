package com.example.demo.entity


import com.example.demo.enums.CountType
import javax.persistence.*

@Entity
@Table(name = "product")
data class ProductEntity (
    @Id
    @GeneratedValue
    val id: Long? = null,

    @Column(name = "name")
    val name_text: String ,

    @Column(name = "buy_price")
    val buy_price: Int ,

    @Column (name = "count_for_one")
    val count_for_one:Int,

    @Enumerated(EnumType.STRING)
    @Column (name = "count_type")
    val count_type: CountType
)


