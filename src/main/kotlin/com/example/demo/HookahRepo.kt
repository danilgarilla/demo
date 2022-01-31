package com.example.demo

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface HookahRepo : CrudRepository<Hookah, Long> {

    @Query("INSERT INTO hookah (name, address) VALUES (:name, :address) RETURNING *", nativeQuery = true)
    fun saveCustom(name: String, address: String): Hookah

    @Query("UPDATE hookah SET name = :name WHERE id=:id", nativeQuery = true)
    fun updateCustom(
        @Param("id") id: Long,
        @Param("name") name: String
    ): Hookah

    @Query("SELECT * FROM hookah", nativeQuery = true)
    fun findAllCustom(): List<Hookah>

    @Query("SELECT * FROM hookah WHERE id=:id", nativeQuery = true)
    fun findByIdCustom(@Param("id") id: Long): Hookah
}