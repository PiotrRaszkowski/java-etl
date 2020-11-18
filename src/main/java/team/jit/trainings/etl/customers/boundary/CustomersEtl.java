package team.jit.trainings.etl.customers.boundary;

import team.jit.trainings.etl.customers.control.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class CustomersEtl {

    public void extractTransformAndLoad(String sourceFileName, String destinationFileName) {
        try {
            CustomersContainer customersContainer = readCustomers(sourceFileName);

            Path destinationFile = Files.createFile(Paths.get(destinationFileName));

            CustomersWriter customersWriter = new CustomersWriter();
            customersWriter.writeCustomers(customersContainer, destinationFile);
        } catch (IOException e) {
            throw new Error(MessageFormat.format("Unable to create destination file = {0}.", destinationFileName), e);
        }
    }

    private CustomersContainer readCustomers(String sourceFileName) {
        CustomersReader customersReader = CustomersReaderFactory.newCustomersReader(CustomersReaderType.CSV);
        return customersReader.readCustomers(sourceFileName);
    }
}
