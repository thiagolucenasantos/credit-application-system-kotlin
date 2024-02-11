package br.com.thiago.creditapplicationsystem.controller

import br.com.thiago.creditapplicationsystem.dto.CustomerUpdateDto
import br.com.thiago.creditapplicationsystem.dto.CustomerView
import br.com.thiago.creditapplicationsystem.dto.CustumerDto
import br.com.thiago.creditapplicationsystem.entity.Customer
import br.com.thiago.creditapplicationsystem.service.impl.CustomerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController // anotação de classe de controle
@RequestMapping("/api/customers")
class CustomerResource(
    private val customerService: CustomerService
) {
    @PostMapping // método de inserir dados no banco e salvar
    //RequestBody -> estamos avisando que será inserindo os dados através de json no corpo da requisição
    fun saveCustomer(@RequestBody customerDto: CustumerDto): String {
        val savedCustomer = this.customerService.save(customerDto.toEntity())
        return "Customer ${savedCustomer.email} saved!"
    }

    @GetMapping("/{id}")
    //PathVariable -> mostra qual a forma que irá chegar esse ID
    fun findyId(@PathVariable id: Long): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        return CustomerView(customer)
    }

    @DeleteMapping("{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.customerService.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody custumerUpdateDto: CustomerUpdateDto
    ): CustomerView {
        val customer: Customer = this.customerService.findById(id)
        val customerToUpdate: Customer = custumerUpdateDto.toEntity(customer)
        val customerUpdated: Customer = this.customerService.save(customerToUpdate)
        return CustomerView(customerUpdated)
    }
}