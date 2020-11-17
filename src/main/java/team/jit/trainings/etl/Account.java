package team.jit.trainings.etl;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Account {
    private String accountNumber;

    private String bankName;

    private AccountStatus accountStatus;
}
