package br.com.thiago.creditapplicationsystem.exception

import java.time.LocalDateTime

//CLASSE PARA TRATAMENTOS DAS EXCEPTIONS, FAZENDO COM QUE OS ERROS FIQUEM MAIS
//FÁCEIS DE SEREM ENTENDIDOS.
data class ExceptionDetails(
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val details: MutableMap<String,String?>
)
