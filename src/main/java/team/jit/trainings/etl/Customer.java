package team.jit.trainings.etl;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@ToString
public class Customer {
    private String name;

    private String surname;

    private LocalDate birthDate;

    private Address address;

    private List<Account> accounts;
}
