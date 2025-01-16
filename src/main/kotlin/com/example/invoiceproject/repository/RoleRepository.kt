package com.example.invoiceproject.repository

import com.example.invoiceproject.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepository: JpaRepository<RoleEntity, String> {

}