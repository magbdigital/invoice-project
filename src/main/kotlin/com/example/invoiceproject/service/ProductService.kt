package com.example.invoiceproject.service

import com.example.invoiceproject.entity.Client
import com.example.invoiceproject.entity.Product
import com.example.invoiceproject.repository.ClientRepository
import com.example.invoiceproject.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service //anotacion
class ProductService {
    @Autowired  // Inyectar un obj de tipo CLientR desde
    lateinit var productRepository: ProductRepository

    fun list (): List<Product> {
        return productRepository.findAll() //select * from Client --Jpa repostprty
    }

    fun save(product: Product):Product{
        return productRepository.save(product) // insert into ... JPaRepository
    }
}