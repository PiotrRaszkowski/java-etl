package team.jit.trainings.etl;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Builder
@Getter
@ToString
public class Customer implements HasKey {
    private String name;

    private String surname;

    private LocalDate birthDate;

    private Address address;

    private Set<Account> accounts;

    public String getKey() {
        return normalizeElement(name) + normalizeElement(surname) + normalizeElement(birthDate.format(DateTimeFormatter.ISO_DATE)) + address.getKey();
    }
}
