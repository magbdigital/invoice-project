package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<UserEntity, String> {
    fun findByUsername(username: String): UserEntity?
}