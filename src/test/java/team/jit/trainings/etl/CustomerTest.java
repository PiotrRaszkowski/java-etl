package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CustomerTest {

    @Test
    public void getKeyGivenCase1() {
        //GIVEN
        Address address = Mockito.mock(Address.class);
        doReturn("address").when(address).getKey();

        Customer customer = Customer.builder().name("name").surname("surname").birthDate(LocalDate.of(1990, 3, 14)).address(address).build();

        //WHEN
        String key = customer.getKey();

        //THEN
        assertEquals("namesurname1990-03-14address", key);
    }

    @Test
    public void getKeyGivenCase2() {
        //GIVEN
        Address address = Mockito.mock(Address.class);
        doReturn("address").when(address).getKey();

        Customer customer = Customer.builder().name("NAME").surname("surname").birthDate(LocalDate.of(1990, 3, 14)).address(address).build();

        //WHEN
        String key = customer.getKey();

        //THEN
        assertEquals("namesurname1990-03-14address", key);
    }

    @Test
    public void getKeyGivenCase3() {
        //GIVEN
        Address address = Mockito.mock(Address.class);
        doReturn("address").when(address).getKey();

        Customer customer = Customer.builder().name(" namE").surname("suRname ").birthDate(LocalDate.of(1990, 3, 14)).address(address).build();

        //WHEN
        String key = customer.getKey();

        //THEN
        assertEquals("namesurname1990-03-14address", key);
    }
}