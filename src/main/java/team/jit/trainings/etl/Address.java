package team.jit.trainings.etl;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Address {
    private String street;

    private String postalCode;

    private String city;
}
