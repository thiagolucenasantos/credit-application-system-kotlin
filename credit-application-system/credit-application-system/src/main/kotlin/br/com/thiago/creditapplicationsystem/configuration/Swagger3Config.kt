package br.com.thiago.creditapplicationsystem.configuration

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//classe de configuração da documentação do projeto
@Configuration
class Swagger3Config {
    @Bean
    fun publicApi(): GroupedOpenApi?{
        return GroupedOpenApi.builder()
            .group("Springcreditapplicationsystem-public")
            .pathsToMatch("/api/customers/**", "/api/credits/**") // os ** no final irá envolver tudo o que tem no projetode customers e credits
            .build()
    }
}