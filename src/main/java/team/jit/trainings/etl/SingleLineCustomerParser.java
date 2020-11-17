package team.jit.trainings.etl;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SingleLineCustomerParser {

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
