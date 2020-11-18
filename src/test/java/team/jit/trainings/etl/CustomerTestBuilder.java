package team.jit.trainings.etl;

import team.jit.trainings.etl.customers.entity.Account;
import team.jit.trainings.etl.customers.entity.AccountStatus;
import team.jit.trainings.etl.customers.entity.Address;
import team.jit.trainings.etl.customers.entity.Customer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CustomerTestBuilder {

    public Customer newFullCustomer() {
        return newFullCustomer("Jan", "Nowak");
    }

    public Customer newFullCustomer(String name, String surname) {
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

        Set<Account> accounts = new HashSet<>();
        accounts.add(account);

        Customer customer = Customer.builder()
                .name(name)
                .surname(surname)
                .birthDate(LocalDate.of(1987, 4, 15))
                .address(address)
                .accounts(accounts)
                .build();

        return customer;
    }
}
