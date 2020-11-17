package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    public void test1() {
        //GIVEN
        Address address = Address.builder().street("street").city("city").postalCode("postalCode").build();

        //WHEN
        String key = address.getKey();

        //THEN
        assertEquals("streetcitypostalcode", key);
    }

    @Test
    public void test2() {
        //GIVEN
        Address address = Address.builder().street("Street").city(" CiTy").postalCode("postalCode").build();

        //WHEN
        String key = address.getKey();

        //THEN
        assertEquals("streetcitypostalcode", key);
    }

    @Test
    public void test3() {
        //GIVEN
        Address address = Address.builder().street("STREET").city("CITY").postalCode("POSTALCODE ").build();

        //WHEN
        String key = address.getKey();

        //THEN
        assertEquals("streetcitypostalcode", key);
    }
}