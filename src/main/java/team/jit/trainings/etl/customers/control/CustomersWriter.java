package team.jit.trainings.etl.customers.control;

import team.jit.trainings.etl.customers.entity.UnableToConvertException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.MessageFormat;

public class CustomersWriter {

    private CustomersJsonConverter customersConverter = new CustomersJsonConverter();

    public void writeCustomers(CustomersContainer customersContainer, Path destinationFile) {
        try (Writer writer = Files.newBufferedWriter(destinationFile)) {
            customersConverter.convertToJson(customersContainer, writer);
        } catch (IOException | UnableToConvertException e) {
            throw new Error(MessageFormat.format("Unable to save to selected file = {0}.", destinationFile.toString()), e);
        }
    }
}
