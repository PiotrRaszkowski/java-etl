package team.jit.trainings.etl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;

public class CustomersReader {

    private SingleLineCustomerParser singleLineCustomerParser = new SingleLineCustomerParser();

    public CustomersContainer readCustomers(String fileName) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            bufferedReader.readLine();

            CustomersContainer customersContainer = new CustomersContainer();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Customer customer = singleLineCustomerParser.parse(line);

                customersContainer.add(customer);
            }

            return customersContainer;
        } catch (IOException e) {
            throw new Error(MessageFormat.format("File = {0} does not exists!", fileName), e);
        }
    }
}
