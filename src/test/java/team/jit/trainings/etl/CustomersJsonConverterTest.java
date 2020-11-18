package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.control.CustomersContainer;
import team.jit.trainings.etl.customers.control.CustomersJsonConverter;
import team.jit.trainings.etl.customers.entity.UnableToConvertException;

import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;

class CustomersJsonConverterTest {

    private CustomersJsonConverter customersJsonConverter = new CustomersJsonConverter();

    private CustomersContainerTestBuilder customersContainerTestBuilder = new CustomersContainerTestBuilder();

    @Test
    public void convertToJson() throws UnableToConvertException {
        //GIVEN
        CustomersContainer customersContainer = customersContainerTestBuilder.withSingleCustomer();

        StringWriter stringWriter = new StringWriter();

        //WHEN
        customersJsonConverter.convertToJson(customersContainer, stringWriter);

        //THEN
        assertEquals("[{\"name\":\"Jan\",\"surname\":\"Nowak\",\"birthDate\":{\"year\":1987,\"month\":4,\"day\":15},\"address\":{\"street\":\"Wiktoriańska 13\",\"postalCode\":\"80-126\",\"city\":\"Elbląg\"},\"accounts\":[{\"accountNumber\":\"123321\",\"bankName\":\"mBank\",\"accountStatus\":\"ACTIVE\"}]}]", stringWriter.toString());
    }

    @Test
    public void convertToJsonGivenMultipleCustomers() throws UnableToConvertException {
        //GIVEN
        CustomersContainer customersContainer = customersContainerTestBuilder.withMultipleCustomer();

        StringWriter stringWriter = new StringWriter();

        //WHEN
        customersJsonConverter.convertToJson(customersContainer, stringWriter);

        //THEN
        assertEquals("[{\"name\":\"Jan\",\"surname\":\"Nowak\",\"birthDate\":{\"year\":1987,\"month\":4,\"day\":15},\"address\":{\"street\":\"Wiktoriańska 13\",\"postalCode\":\"80-126\",\"city\":\"Elbląg\"},\"accounts\":[{\"accountNumber\":\"123321\",\"bankName\":\"mBank\",\"accountStatus\":\"ACTIVE\"}]},{\"name\":\"Adam\",\"surname\":\"Kowalski\",\"birthDate\":{\"year\":1987,\"month\":4,\"day\":15},\"address\":{\"street\":\"Wiktoriańska 13\",\"postalCode\":\"80-126\",\"city\":\"Elbląg\"},\"accounts\":[{\"accountNumber\":\"123321\",\"bankName\":\"mBank\",\"accountStatus\":\"ACTIVE\"}]}]", stringWriter.toString());
    }
}