package br.com.thiago.creditapplicationsystem.entity

import jakarta.annotation.Generated
import jakarta.persistence.*
import java.math.BigDecimal

@Entity // classe que se tornará uma tabela no banco de dados
//@Table(name = "Cliente") // alterando o nome da tabela
data class Customer(
    //@Column - tipo não pode ser nula
    @Column(nullable = false) var firstName: String = "",
    @Column(nullable = false) var lastName: String = "",
    @Column(nullable = false, unique = true) var cpf: String = "",
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var income: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) var password: String = "",
    @Column(nullable = false) @Embedded var address: Address = Address(),
    //@OneToMany -> um Customer pode ter vários Credits
    //FetchType.LAZY -> credits só será mostrado quando pedido
    //CascadeType.REMOVE -> quando o usuário for removido seus credits também serão
    @Column(nullable = false) @OneToMany(
        fetch = FetchType.LAZY,
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
    mappedBy = "customer")
    var credits: List<Credit> = mutableListOf(),
    //@ID -> adicii=onando chave primaria no atributo id
    //@GenerationType -> adicionando o tipo de geração de ID
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
