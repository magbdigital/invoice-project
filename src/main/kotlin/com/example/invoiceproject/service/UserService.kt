package com.example.invoiceproject.service

import com.example.invoiceproject.dto.LoginDto
import com.example.invoiceproject.entity.RoleEntity
import com.example.invoiceproject.entity.UserEntity
import com.example.invoiceproject.repository.RoleRepository
import com.example.invoiceproject.repository.UserRepository
import com.example.invoiceproject.response.ResponseDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.SQLException

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    fun list(): List<UserEntity> {
        return userRepository.findAll()
    }

    fun listById(id: Long?): UserEntity? {
        return userRepository.findById(id)
    }

    fun listRolesByUserId(id: Long?): List<RoleEntity>? {
        return roleRepository.findByUserId(id)
    }

    fun updatePassword(loginDto: LoginDto): UserEntity? {
        val response = userRepository.findByUsername(loginDto.username!!)
            ?: throw Exception()
        response.apply {
            password = BCryptPasswordEncoder().encode(loginDto.password)
        }
        return userRepository.save(response)
    }

    @Transactional
    fun delete(id: Long?): ResponseDto? {
        try {
            val toDelete = userRepository.findById(id)
                ?: throw Exception("Id does not exist")
            roleRepository.deleteByUserId(id)
            toDelete.id?.let {
                userRepository.deleteById(it)
            }
            return ResponseDto().apply {
                status = "success"
            }
        } catch (e: DataIntegrityViolationException) {
            throw SQLException("Data integrity violation")
        } catch (e: Exception) {
            throw SQLException(e.message)
        }

    }
}