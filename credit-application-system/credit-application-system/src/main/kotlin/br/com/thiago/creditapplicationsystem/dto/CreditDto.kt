package br.com.thiago.creditapplicationsystem.dto

import br.com.thiago.creditapplicationsystem.entity.Credit
import br.com.thiago.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    @NotNull(message = "Invalid income!!") val creditValue: BigDecimal,
    @field:Future(message = "Data não pode ser passada!") val dayFirstOffInstallment: LocalDate,
    @field:Future(message = "Data não pode ser passada!") val numbertOffInstallment: Int,
    @NotNull(message = "Invalid income!!")val customerId: Long,

    ){

fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstInstaltment = this.dayFirstOffInstallment,
    numberOfInstaltment = this.numbertOffInstallment,
    customer = Customer(id = this.customerId)

    )

}
