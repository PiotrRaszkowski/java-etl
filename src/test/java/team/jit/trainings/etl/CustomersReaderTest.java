package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersReaderTest {

    @Test
    void readCustomersGivenFileWithCustomers() {
        //GIVEN
        CustomersReader customersReader = new CustomersReader();

        //WHEN
        CustomersContainer customersContainer = customersReader.readCustomers("src/test/resources/customers.csv");

        //THEN
        assertEquals(6, customersContainer.size());
    }

    @Test
    void readCustomersGivenNotExistingFile() {
        //GIVEN
        CustomersReader customersReader = new CustomersReader();

        //WHEN
        Error error = assertThrows(Error.class, () -> customersReader.readCustomers("src/test/resources/not-existing-file.csv"));

        //THEN
        assertEquals("File = src/test/resources/not-existing-file.csv does not exists!", error.getMessage());
    }
}