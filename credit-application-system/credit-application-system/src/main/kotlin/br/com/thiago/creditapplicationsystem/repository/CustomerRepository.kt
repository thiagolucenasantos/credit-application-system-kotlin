package br.com.thiago.creditapplicationsystem.repository

import br.com.thiago.creditapplicationsystem.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


//Classes repository que irão fazer a conexão diretamente com o Banco de dados
@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {
}