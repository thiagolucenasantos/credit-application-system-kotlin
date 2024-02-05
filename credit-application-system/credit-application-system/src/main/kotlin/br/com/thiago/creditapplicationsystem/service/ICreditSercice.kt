package br.com.thiago.creditapplicationsystem.service

import br.com.thiago.creditapplicationsystem.entity.Credit
import java.util.*

interface ICreditSercice {
    //salvar
    fun save(credit: Credit): Credit

    //encontrar uma lista com todos os créditos de um determinado customer
    fun findByAllCustomer(customerId: Long): List<Credit>

    //encontrar os créditos de acordo com seu creditCode
    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit
}