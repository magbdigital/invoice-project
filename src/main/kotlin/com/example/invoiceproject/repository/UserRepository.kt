package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findByUsername(username: String): UserEntity?
    fun findById (id: Long?): UserEntity?
}