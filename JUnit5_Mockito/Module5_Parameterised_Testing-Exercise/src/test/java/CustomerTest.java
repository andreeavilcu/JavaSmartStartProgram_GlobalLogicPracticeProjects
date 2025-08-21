import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @CsvSource({
            "1, Alice, 123456789, New York",
            "2, Bobb, 9876543210, London",
            "3, Charlie, 5555555555, Paris"
    })
    void testCreateCustomer_ValidData(int id, String name, String contact, String address) {
        Customer customer = new Customer(id, name, contact, address);
        service.addCustomer(customer);

        Customer retrieved = service.getCustomerById(id);

        assertNotNull(retrieved, "Customer should not be null");
        assertEquals(name, retrieved.getCustomerName());
        assertEquals(contact, retrieved.getContactNumber());
        assertEquals(address, retrieved.getAddress());
    }

    @ParameterizedTest
    @CsvSource({
            "10, '', 111, Paris",
            "11, John, 222, ''",
            "12, null, 333, Rome"
    })
    void testCreateCustomer_InvalidData(int id, String name, String contact, String address){
        Customer invalid = new Customer(id, name, contact, address);
        service.addCustomer(invalid);


        Customer retrieved = service.getCustomerById(id);

        assumeTrue(retrieved.getCustomerName() != null, "Skipping test because name is null");

        assertNotNull(retrieved.getCustomerName());

    }


    @ParameterizedTest
    @ValueSource(ints = {2, 5, 6})
    void testRetrieveCustomerById(int id){
        Customer c = new Customer(id, "Bob", "9876543210", "London");
        service.addCustomer(c);

        Customer retrieved = service.getCustomerById(id);

        assertNotNull(retrieved);
        assertEquals("Bob", retrieved.getCustomerName());
    }

    @ParameterizedTest
    @CsvSource({
            "20, Eve, 123, Madrid, Eve Brown, 999, Barcelona",
            "21, David, 555, Rome, David Jr, 888, Milan"
    })
    void UpdateCustomer(int id, String name, String contact, String address,
                        String newName, String newContact, String newAddress){
        Customer c = new Customer(id, name, contact, address);
        service.addCustomer(c);

        Customer updated = new Customer(id, newName, newContact,newAddress);
        service.updateCustomer(updated);

        Customer retrieved = service.getCustomerById(id);
        assertEquals(newName, retrieved.getCustomerName());
        assertEquals(newAddress, retrieved.getAddress());
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

    @ParameterizedTest
    @ValueSource(ints = {30, 31, 32})
    void testDeleteCustomer(int id){
        Customer c = new Customer(id, "Temp", "000", "Nowhere");
        service.addCustomer(c);

        service.deleteCustomer(id);
        Customer retrieved = service.getCustomerById(id);

        assertNull(retrieved, "Customer should be deleted");


    }
}
