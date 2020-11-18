package team.jit.trainings.etl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import team.jit.trainings.etl.customers.control.CustomersContainer;
import team.jit.trainings.etl.customers.control.CustomersJsonConverter;
import team.jit.trainings.etl.customers.control.CustomersWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
class CustomersWriterTest {

    @Mock
    private CustomersJsonConverter customersJsonConverter;

    @InjectMocks
    private CustomersWriter customersWriter;

    private Path tempFile;

    private CustomersContainerTestBuilder customersContainerTestBuilder = new CustomersContainerTestBuilder();

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("customers", "");
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void writeCustomersWhenNoException() throws Exception {
        //GIVEN
        CustomersContainer customersContainer = customersContainerTestBuilder.withSingleCustomer();

        //WHEN
        customersWriter.writeCustomers(customersContainer, tempFile);

        //THEN
        Mockito.verify(customersJsonConverter, Mockito.only()).convertToJson(eq(customersContainer), any());
    }

    @Test
    public void writeCustomersWhenUnableToSave() throws Exception {
        //GIVEN
        CustomersContainer customersContainer = customersContainerTestBuilder.withSingleCustomer();

        //WHEN
        Error error = Assertions.assertThrows(Error.class, () -> customersWriter.writeCustomers(customersContainer, Files.createTempDirectory("custDir")));

        //THEN
        assertTrue(error.getMessage().startsWith("Unable to save to selected file ="));
    }
}