package br.com.thiago.creditapplicationsystem.entity

import br.com.thiago.creditapplicationsystem.ennumeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
@Entity // classe que se tornará uma tabela no banco de dados
@Table(name = "Credit") // alterando o nome da tabela
data class Credit (
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstaltment: LocalDate,
    val numberOfInstaltment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    //ManyToOne -> muitos creditos podem pertencer a um Customer
    @ManyToOne val customer: Customer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)


