package br.com.thiago.creditapplicationsystem.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable // referencia diretamente no atributo da Classe Customer
data class Address(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var street: String = ""
)
