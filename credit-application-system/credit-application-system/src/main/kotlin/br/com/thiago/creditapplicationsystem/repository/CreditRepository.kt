package br.com.thiago.creditapplicationsystem.repository

import br.com.thiago.creditapplicationsystem.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

//Classes repository que irão fazer a conexão diretamente com o Banco de dados
@Repository
interface CreditRepository: JpaRepository<Credit, Long > {
    fun findByCreditCode(creditCode: UUID): Credit?

    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>
}