package br.com.thiago.creditapplicationsystem.dto

import br.com.thiago.creditapplicationsystem.entity.Credit

import java.math.BigDecimal
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberofInstallments: Int
) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberofInstallments = credit.numberOfInstaltment
    )
}
