package com.example.courseservice;

import com.example.courseservice.models.Booking;
import com.example.courseservice.models.Course;
import com.example.courseservice.models.Customer;
import com.example.courseservice.repositories.BookingRepository;
import com.example.courseservice.repositories.CourseRepository;
import com.example.courseservice.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseserviceApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

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

	@Test
	public void canCreateBooking() {
		Customer customer = new Customer("Tim", "Timtown", 47);
		customerRepository.save(customer);
		LocalDate date = LocalDate.of(1900, 8, 10);
		Course course = new Course("Python5", "Pennpen", 3);
		courseRepository.save(course);
		Booking booking = new Booking(date, course, customer);
		bookingRepository.save(booking);
	}
}
