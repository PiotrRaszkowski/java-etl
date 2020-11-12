package team.jit.trainings.etl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CustomersReader {

    public List<Customer> readCustomers(String fileName) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            bufferedReader.readLine();

            List<Customer> customers = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split("\\|");

                String name = elements[0];
                String surname = elements[1];
                LocalDate birthDate = LocalDate.parse(elements[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String street = elements[3];
                String postalCode = elements[4];
                String city = elements[5];
                String accountNumber = elements[6];
                String bankName = elements[7];
                AccountStatus accountStatus = AccountStatus.from(elements[8]);

                Account account = Account.builder()
                        .accountNumber(accountNumber)
                        .bankName(bankName)
                        .accountStatus(accountStatus)
                        .build();
                Address address = Address.builder()
                        .street(street)
                        .postalCode(postalCode)
                        .city(city)
                        .build();
                Customer customer = Customer.builder()
                        .name(name)
                        .surname(surname)
                        .birthDate(birthDate)
                        .address(address)
                        .accounts(List.of(account))
                        .build();

                customers.add(customer);
            }

            return customers;
        } catch (IOException e) {

        }

        return null;
    }
}
