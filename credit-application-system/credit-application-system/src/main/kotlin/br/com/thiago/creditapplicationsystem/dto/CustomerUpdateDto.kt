package br.com.thiago.creditapplicationsystem.dto

import br.com.thiago.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field: NotEmpty(message = "Cannot be null") val firstName: String,
    @field: NotEmpty(message = "Cannot be null") val lastName: String,
    @NotNull(message = "Invalid income!!") val income: BigDecimal,
    @field: NotEmpty(message = "Cannot be null") val zipCode: String,
    @field: NotEmpty(message = "Cannot be null") val street: String
) {
    fun toEntity(customer: Customer) : Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = this.street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
