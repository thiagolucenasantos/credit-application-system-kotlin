package br.com.thiago.creditapplicationsystem.service

import br.com.thiago.creditapplicationsystem.entity.Address
import br.com.thiago.creditapplicationsystem.entity.Customer
import br.com.thiago.creditapplicationsystem.exception.BusinessException
import br.com.thiago.creditapplicationsystem.repository.CustomerRepository
import br.com.thiago.creditapplicationsystem.service.impl.CustomerService
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal
import java.util.*

//@ActiveProfiles("test")//tem que ter o nome de test, na classe resources para a Anottation reconhecer, como no exemplo appication-test.properties, porém não há necessidade nesse teste porque ele não sobe o contexto do spring
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK
    lateinit var customerRepository: CustomerRepository //aplicando o Mock no CusomerRepository, para criar um falso nos testes

    @InjectMockKs
    lateinit var customerService: CustomerService // simulando a classe que será testada

    @Test
    fun `should create customer`() {
        //given -> dados que precisamos receber para fazer o teste,nesse caso o customer
        val fakeCustomer: Customer = buildCustomer()
        every { customerRepository.save(any()) } returns fakeCustomer

        //when -> parte de fato que teremos o método que devemos testar, o CustomerService save
        val actual: Customer = customerService.save(fakeCustomer)

        //then -> parte em que verificamos se realmente o resultado foi como esperado
        //TESTES NO MÉTODO DE SAVE
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerRepository.save(fakeCustomer) }
    }

    //TESTE DO findById
    @Test
    fun `should find customer by id`() {
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = buildCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        //when
        val actual: Customer = customerService.findById(fakeId)
        //then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        Assertions.assertThat(actual).isExactlyInstanceOf(Customer::class.java)
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    //TESTANDO EXCEPTIONS DO findById
    @Test
    fun `should not find customer by id and throw BusinessException`() {
        //given
        val fakeId: Long = Random().nextLong()
        every { customerRepository.findById(fakeId) } returns Optional.empty()
        //when
        //then
        Assertions.assertThatExceptionOfType(BusinessException::class.java)
            .isThrownBy { customerService.findById(fakeId) }
            .withMessage("Id $fakeId not found")
        verify(exactly = 1) { customerRepository.findById(fakeId) }
    }

    //TESTANDO O MÉTODO delete
    @Test
    fun `should delete customer by id`(){
        //given
        val fakeId: Long = Random().nextLong()
        val fakeCustomer: Customer = buildCustomer(id = fakeId)
        every { customerRepository.findById(fakeId) } returns Optional.of(fakeCustomer)
        every { customerRepository.delete(fakeCustomer) } just runs //just runs apenas irá deletar e rodar sem mostrar nada
        //when
        customerService.delete(fakeId)
        //then
        verify(exactly = 1) { customerRepository.findById(fakeId) }
        verify(exactly = 1) { customerRepository.delete(fakeCustomer) }
    }


    //método de customer fake
    private fun buildCustomer(
        firstName: String = "Thiago",
        lastName: String = "Silva",
        cpf: String = "28475934625",
        email: String = "thiago@gmail.com",
        password: String = "12345",
        zipCode: String = "12345",
        street: String = "Rua dois",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
    ) = Customer(
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        password = password,
        address = Address(
            zipCode = zipCode,
            street = street,
        ),
        income = income,
        id = id
    )
}
