package team.jit.trainings.etl.customers.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    private Address address;

    private Set<Account> accounts;

    public String getKey() {
        return normalizeElement(name) + normalizeElement(surname) + normalizeElement(birthDate.format(DateTimeFormatter.ISO_DATE)) + address.getKey();
    }
}
