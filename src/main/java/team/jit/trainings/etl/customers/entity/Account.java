package team.jit.trainings.etl.customers.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import team.jit.trainings.etl.customers.entity.AccountStatus;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Account {
    private String accountNumber;

    private String bankName;

    private AccountStatus accountStatus;
}
