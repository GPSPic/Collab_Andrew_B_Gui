package com.example.courseservice.repositories;

import com.example.courseservice.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

//    List<Customer> findCustomerByBookingsCourseName(String courseName);
}
