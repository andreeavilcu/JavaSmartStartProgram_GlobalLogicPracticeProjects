package org.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();


    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == customerId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer existing = getCustomerById(customer.getCustomerId());
        if(existing != null){
            existing.setCustomerName(customer.getCustomerName());
            existing.setContactNumber(customer.getContactNumber());
            existing.setAddress(customer.getAddress());
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        customers.removeIf(c -> c.getCustomerId() == customerId);
    }
}
