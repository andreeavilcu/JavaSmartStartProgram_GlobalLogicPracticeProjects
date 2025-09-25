package com.example.ecommerce_order_system.service;

import com.example.ecommerce_order_system.model.Customer;
import com.example.ecommerce_order_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customerId){
        return customerRepository.findById(customerId);
    }

    public Optional<Customer> getCustomerByEmail(String email){
        return  customerRepository.findByEmail(email);
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
