package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomersReaderTest {

    @Test
    void test() {
        //GIVEN
        CustomersReader customersReader = new CustomersReader();

        //WHEN
        List<Customer> customers = customersReader.readCustomers("src/test/resources/customers.csv");

        //THEN
        assertEquals(4, customers.size());
    }
}