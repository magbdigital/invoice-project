package com.example.invoiceproject.controller


import com.example.invoiceproject.dto.LoginDto
import com.example.invoiceproject.service.UserSecurityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController {

    @Autowired
    lateinit var userSecurityService: UserSecurityService

    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<*>? {
        val response = userSecurityService.login(loginDto)
        return ResponseEntity(response, HttpStatus.OK)
    }
}