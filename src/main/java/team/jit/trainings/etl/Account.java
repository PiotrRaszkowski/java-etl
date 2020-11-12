package team.jit.trainings.etl;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Account {
    private String accountNumber;

    private String bankName;

    private AccountStatus accountStatus;
}
