package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.control.CSVCustomersReader;
import team.jit.trainings.etl.customers.control.CustomersContainer;

import static org.junit.jupiter.api.Assertions.*;

class CSVCustomersReaderTest {

    @Test
    void readCustomersGivenFileWithCustomers() {
        //GIVEN
        CSVCustomersReader CSVCustomersReader = new CSVCustomersReader();

        //WHEN
        CustomersContainer customersContainer = CSVCustomersReader.readCustomers("src/test/resources/customers.csv");

        //THEN
        assertEquals(6, customersContainer.size());
    }

    @Test
    void readCustomersGivenNotExistingFile() {
        //GIVEN
        CSVCustomersReader CSVCustomersReader = new CSVCustomersReader();

        //WHEN
        Error error = assertThrows(Error.class, () -> CSVCustomersReader.readCustomers("src/test/resources/not-existing-file.csv"));

        //THEN
        assertEquals("File = src/test/resources/not-existing-file.csv does not exists!", error.getMessage());
    }
}