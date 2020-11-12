package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountStatusTest {

    @Test
    public void fromGivenExistingCsvValue() {
        //GIVEN
        String csvValue = "ZABLOKOWANE";

        //WHEN
        AccountStatus accountStatus = AccountStatus.from(csvValue);

        //THEN
        assertEquals(AccountStatus.BLOCKED, accountStatus);
    }

    @Test
    public void fromGivenNotExistingCsvValue() {
        //GIVEN
        String csvValue = "ty też tralalala";

        //WHEN
        assertThrows(IllegalArgumentException.class, () -> AccountStatus.from(csvValue));

        //THEN
    }

}