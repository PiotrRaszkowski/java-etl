package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.control.CustomersContainer;
import team.jit.trainings.etl.customers.entity.Account;
import team.jit.trainings.etl.customers.entity.AccountStatus;
import team.jit.trainings.etl.customers.entity.Address;
import team.jit.trainings.etl.customers.entity.Customer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class CustomersContainerTest {

    @Test
    public void addThenNewCustomerAdded() {
        //GIVEN
        CustomersContainer customersContainer = new CustomersContainer();

        Customer customer = mock(Customer.class);
        doReturn("key").when(customer).getKey();

        //WHEN
        customersContainer.add(customer);

        //THEN
        assertEquals(1, customersContainer.size());
    }

    @Test
    public void addWhenAddingDuplicatedCustomer() {
        //GIVEN
        CustomersContainer customersContainer = new CustomersContainer();

        Customer customer1 = mock(Customer.class);
        doReturn("key").when(customer1).getKey();

        Customer customer2 = mock(Customer.class);
        doReturn("key").when(customer2).getKey();

        customersContainer.add(customer1);

        //WHEN
        customersContainer.add(customer2);

        //THEN
        assertEquals(1, customersContainer.size());
    }

    @Test
    public void addWhenAddingDuplicatedCustomerWithSameAccounts() {
        //GIVEN
        CustomersContainer customersContainer = new CustomersContainer();

        Account account1 = Account.builder()
                .accountNumber("123")
                .bankName("bank")
                .accountStatus(AccountStatus.ACTIVE)
                .build();

        Customer customer1 = Customer.builder()
                .name("name")
                .surname("surname")
                .birthDate(LocalDate.of(2020, 1, 1))
                .address(Address.builder().build())
                .accounts(new HashSet<>(Set.of(account1)))
                .build();

        Account account2 = Account.builder()
                .accountNumber("123")
                .bankName("bank")
                .accountStatus(AccountStatus.ACTIVE)
                .build();

        Customer customer2 = Customer.builder()
                .name("name")
                .surname("surname")
                .birthDate(LocalDate.of(2020, 1, 1))
                .address(Address.builder().build())
                .accounts(new HashSet<>(Set.of(account2)))
                .build();

        customersContainer.add(customer1);

        //WHEN
        customersContainer.add(customer2);

        //THEN
        assertEquals(1, customersContainer.size());
        assertEquals(1, customersContainer.toList().get(0).getAccounts().size());

    }
}