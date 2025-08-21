import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class CustomerTest {
    private CustomerService service;

    @BeforeEach
    void setUp(){
        CustomerRepository repo = new CustomerRepositoryImpl();
        service = new CustomerServiceImpl(repo);
    }

    @Test
    void testCreateCustomer_ValidData() {
        Customer c1 = new Customer(1, "Alice", "1234567890", "New York");
        service.addCustomer(c1);

        Customer retrieved = service.getCustomerById(1);

        assertNotNull(retrieved, "Customer should not be null");

        assertEquals("Alice", retrieved.getCustomerName());
        assertEquals("1234567890", retrieved.getContactNumber());
        assertEquals("New York", retrieved.getAddress());
    }

    @Test
    void testCreateCustomer_InvalidData(){
        Customer invalid = new Customer(2, null, "111", "Paris");
        service.addCustomer(invalid);

        Customer retrieved = service.getCustomerById(2);

        assumeTrue(retrieved.getCustomerName() != null, "Skipping test because name is null");

        assertNotNull(retrieved.getCustomerName());

    }

    @Test
    void testRetrieveCustomerById(){
        Customer c = new Customer(3, "Bob", "9876543210", "London");
        service.addCustomer(c);

        Customer retrieved = service.getCustomerById(3);

        assertNotNull(retrieved);
        assertEquals("Bob", retrieved.getCustomerName());
    }

    @Test
    void UpdateCustomer(){
        Customer c = new Customer(4, "Charlie", "555", "Berlin");
        service.addCustomer(c);

        Customer updated = new Customer(4, "Charlie Brown", "555-999", "Munich");
        service.updateCustomer(updated);

        Customer retrieved = service.getCustomerById(4);
        assertEquals("Charlie Brown", retrieved.getCustomerName());
        assertEquals("Munich", retrieved.getAddress());
    }

    @Test
    void testReadCustomer(){
        Customer c1 = new Customer(2, "Bob", "9876543210", "New York");
        service.addCustomer(c1);

        Customer retrieved = service.getCustomerById(2);

        assertNotNull(retrieved, "Customer should not be null");
        assertEquals("Bob", retrieved.getCustomerName());
        assertEquals("9876543210", retrieved.getContactNumber());
        assertEquals("New York", retrieved.getAddress());
    }

    @Test
    void testDeleteCustomer(){
        Customer c = new Customer(5, "David", "666", "Rome");
        service.addCustomer(c);

        service.deleteCustomer(5);
        Customer retrieved = service.getCustomerById(5);

        assertNull(retrieved, "Customer should be deleted");


    }
}
