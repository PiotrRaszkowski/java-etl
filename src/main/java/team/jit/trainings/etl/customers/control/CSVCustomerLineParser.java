package team.jit.trainings.etl.customers.control;

import org.apache.commons.lang3.StringUtils;
import team.jit.trainings.etl.customers.entity.Account;
import team.jit.trainings.etl.customers.entity.AccountStatus;
import team.jit.trainings.etl.customers.entity.Address;
import team.jit.trainings.etl.customers.entity.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.List;

public class CSVCustomerLineParser {

    public Customer parse(String line) {
        String[] elements = line.split("\\|");

        String name = elements[0];
        String surname = elements[1];
        LocalDate birthDate = parseBirthDate(elements[2]);
        String street = StringUtils.normalizeSpace(elements[3]);
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
                .accounts(new HashSet<>(List.of(account)))
                .build();

        return customer;
    }

    private LocalDate parseBirthDate(String birthDate) {
        try {
            return LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeParseException e) {
            return LocalDate.EPOCH;
        }
    }
}
