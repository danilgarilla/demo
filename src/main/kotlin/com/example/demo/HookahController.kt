package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/hookah")
class HookahController(
    private val hookahRepo: HookahRepo
) {

    @GetMapping("/{name}/{address}")
    fun save(
        @PathVariable("name") name: String,
        @PathVariable("address") address: String
    ): Hookah =
        hookahRepo.saveCustom(name, address)

    @GetMapping("/update/{id}/{name}")
    fun update(
        @PathVariable("id") id: Long,
        @PathVariable("name") name: String
    ): Hookah =
        hookahRepo.updateCustom(id, name)

    @GetMapping("/{id}")
    fun delete(
        @PathVariable("id") id: Long,
    ): String = hookahRepo.deleteById(id).let { "Ура" }


    @GetMapping("/hookah/all")
    fun findAll(): List<Hookah> = hookahRepo.findAllCustom()

}