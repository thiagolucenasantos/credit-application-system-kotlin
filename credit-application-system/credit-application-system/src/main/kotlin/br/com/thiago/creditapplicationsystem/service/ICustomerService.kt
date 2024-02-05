package br.com.thiago.creditapplicationsystem.service

import br.com.thiago.creditapplicationsystem.entity.Customer


interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}