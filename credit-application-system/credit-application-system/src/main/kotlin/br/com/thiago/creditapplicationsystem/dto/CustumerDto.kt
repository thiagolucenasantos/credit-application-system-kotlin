package br.com.thiago.creditapplicationsystem.dto

import br.com.thiago.creditapplicationsystem.entity.Address
import br.com.thiago.creditapplicationsystem.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustumerDto(
    //no kotlin para a anottation @NotEmpty ser reconhecida precisamos colocar field:
   @field: NotEmpty(message = "Cannot be null") val firstName: String,
   @field: NotEmpty(message = "Cannot be null") val lastName: String,
   @CPF(message = "This invalid CPF") val cpf: String,
   @NotNull(message = "Invalid income!!") val income: BigDecimal,
   @field: Email(message = "Invalid e-mail")
   @field: NotEmpty(message = "Cannot be null") val email: String,
   @field: NotEmpty(message = "Cannot be null") val password: String,
   @field: NotEmpty(message = "Cannot be null") val zipCode: String,
   @field: NotEmpty(message = "Cannot be null") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}


