package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CustomersWriterTest {

    @Test
    public void writeCustomers() {
        //GIVEN
        CustomersWriter customersWriter = new CustomersWriter();

        Account account = Account.builder()
                .accountNumber("123321")
                .bankName("mBank")
                .accountStatus(AccountStatus.ACTIVE)
                .build();

        Address address = Address.builder()
                .street("Wiktoriańska 13")
                .postalCode("80-126")
                .city("Elbląg")
                .build();

        Customer customer = Customer.builder()
                .name("Jan")
                .surname("Kowalski")
                .birthDate(LocalDate.of(1987, 4, 15))
                .address(address)
                .accounts(Set.of(account))
                .build();

        CustomersContainer customersContainer = new CustomersContainer();
        customersContainer.add(customer);

        //WHEN
        customersWriter.writeCustomers(customersContainer);


        //THEN
    }
}