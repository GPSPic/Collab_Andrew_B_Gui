package com.example.courseservice;

import com.example.courseservice.models.Customer;
import com.example.courseservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canSaveCustomer() {
		Customer customer = new Customer("Tim", "Timtown", 47);
		customerRepository.save(customer);
	}

	@Test
	public void canGetAllCustomers() {
		assertEquals(1, customerRepository.findAll().size());
	}

	@Test
	public void canGetCustomerId1() {
		assertEquals("Tim", customerRepository.findById(1L).get().getName());
	}

//	@Test
//	public void canDeleteCustomer() {
//		Customer bob = new Customer("Bob", "Bobburough", 47);
//		customerRepository.save(bob);
//		customerRepository.deleteById(2L);
//		assertEquals(1, customerRepository.findAll().size());
//	}

}
