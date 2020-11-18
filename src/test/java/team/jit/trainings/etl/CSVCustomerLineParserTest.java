package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.control.CSVCustomerLineParser;
import team.jit.trainings.etl.customers.entity.Account;
import team.jit.trainings.etl.customers.entity.AccountStatus;
import team.jit.trainings.etl.customers.entity.Customer;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVCustomerLineParserTest {

    @Test
    public void parseGivenCorrectData() {
        //GIVEN
        String line = "Karol|Nowak|14/03/1987|ul.  Nowakowska 26B/5|83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("Karol", customer.getName());
        assertEquals("Nowak", customer.getSurname());
        assertEquals("1987-03-14", customer.getBirthDate().format(DateTimeFormatter.ISO_DATE));
        assertEquals("Nowakowo", customer.getAddress().getCity());
        assertEquals("83-200", customer.getAddress().getPostalCode());
        assertEquals("ul. Nowakowska 26B/5", customer.getAddress().getStreet());

        List<Account> accounts = new ArrayList<>(customer.getAccounts());
        assertEquals("8710101397005500222100000087101013970055002221000000", accounts.get(0).getAccountNumber());
        assertEquals("mBank", accounts.get(0).getBankName());
        assertEquals(AccountStatus.ACTIVE, accounts.get(0).getAccountStatus());
    }

    @Test
    public void parseGivenWrongDateFormat() {
        //GIVEN
        String line = "Karol|Nowak|03/14/1987|ul.  Nowakowska 26B/5|83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("1970-01-01", customer.getBirthDate().format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    public void parseGivenEmptyName() {
        //GIVEN
        String line = "|Nowak|14/03/1987|ul.  Nowakowska 26B/5|83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("", customer.getName());
    }

    @Test
    public void parseGivenEmptySurname() {
        //GIVEN
        String line = "Karol||14/03/1987|ul.  Nowakowska 26B/5|83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("", customer.getSurname());
    }

    @Test
    public void parseGivenEmptyDateThenBirthDateAsEpoch() {
        //GIVEN
        String line = "Karol|Nowak||ul.  Nowakowska 26B/5|83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("1970-01-01", customer.getBirthDate().format(DateTimeFormatter.ISO_DATE));
    }

    @Test
    public void parseGivenMultipleWhitespacesInStreetThenWhitespacesNormalized() {
        //GIVEN
        String line = "Karol|Nowak|14/03/1987|ul.  Nowakowska   26B/5 |83-200|Nowakowo|8710101397005500222100000087101013970055002221000000|mBank|AKTYWNE";

        CSVCustomerLineParser parser = new CSVCustomerLineParser();

        //WHEN
        Customer customer = parser.parse(line);

        //THEN
        assertEquals("ul. Nowakowska 26B/5", customer.getAddress().getStreet());
    }
}