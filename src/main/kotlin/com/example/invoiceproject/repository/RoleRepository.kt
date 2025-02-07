package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface RoleRepository: JpaRepository<RoleEntity, Long> {
    fun findByUserIdAndRole (userId: Long?, role:String?): RoleEntity?
    fun findByUserId (userId: Long?): List<RoleEntity>
    @Modifying
    @Transactional
    @Query("DELETE FROM RoleEntity r WHERE r.user.id = :userId")
    fun deleteByUserId(userId: Long?)
}