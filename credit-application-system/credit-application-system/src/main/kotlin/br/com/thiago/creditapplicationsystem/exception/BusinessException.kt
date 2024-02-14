package br.com.thiago.creditapplicationsystem.exception

//Exception feita por nós
//Precisou ser extendida por RuntimeException e sobscrevemos  o construtor da RuntimeException
data class BusinessException(override val message: String?): RuntimeException(message)