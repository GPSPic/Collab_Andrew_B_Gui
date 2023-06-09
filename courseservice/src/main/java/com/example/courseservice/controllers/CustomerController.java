package com.example.courseservice.controllers;

import com.example.courseservice.models.Customer;
import com.example.courseservice.repositories.CustomerRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<Optional> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @RequestBody Customer customer,
            @PathVariable Long id){
        Customer updatedCustomer = customerRepository.findById(id).get();
            updatedCustomer.setName(customer.getName());
            updatedCustomer.setTown(customer.getTown());
            updatedCustomer.setAge(customer.getAge());

            customerRepository.save(updatedCustomer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }
}
