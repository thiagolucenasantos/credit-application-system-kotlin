package br.com.thiago.creditapplicationsystem.service.impl

import br.com.thiago.creditapplicationsystem.entity.Customer
import br.com.thiago.creditapplicationsystem.repository.CustomerRepository
import br.com.thiago.creditapplicationsystem.service.ICustomerService
import org.springframework.stereotype.Service

//Camada de serviços, camada de implementação de regra de negócio

@Service // anotação de reconhecimento de classe de serviço
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow() {
            throw RuntimeException("Id $id not found")
        }


    override fun delete(id: Long) = this.customerRepository.deleteById(id)
}
