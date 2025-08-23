import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CustomerServiceTest {
    @Mock
    private CustomerRepository repo;

    @InjectMocks
    private CustomerServiceImpl service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @ParameterizedTest
    @CsvSource({
            "1, Alice, 1234567890, New York",
            "2, Bob, 9876543210, London"
    })
    void testAddNewCustomer(int id, String name, String contact, String address){
        Customer customer = new Customer(id, name, contact, address);

        doNothing().when(repo).addCustomer(customer);
        when(repo.getCustomerById(id)).thenReturn(customer);

        service.addCustomer(customer);
        Customer retrieved = service.getCustomerById(id);

        assertNotNull(retrieved);
        assertEquals(name, retrieved.getCustomerName());
        assertEquals(contact, retrieved.getContactNumber());
        assertEquals(address, retrieved.getAddress());

        //verify if a method was called at least once
        verify(repo).addCustomer(customer);
        verify(repo).getCustomerById(id);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testGetCustomerById(int id){
        Customer customer = new Customer(id, "TestName" + id, "000" + id, "City" + id);
       when(repo.getCustomerById(id)).thenReturn(customer);

        Customer retrieved = service.getCustomerById(id);
        assertNotNull(retrieved);

        assertEquals(customer.getCustomerName(), retrieved.getCustomerName());
        verify(repo).getCustomerById(id);
    }

    @Test
    void testDatabaseFailure(){
        int invalidId = 999;
        when(repo.getCustomerById(invalidId)).thenThrow(new RuntimeException("DB connection failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->{
            service.getCustomerById(invalidId);
        });

        assertEquals("DB connection failed", exception.getMessage());
        verify(repo).getCustomerById(invalidId);
    }

}