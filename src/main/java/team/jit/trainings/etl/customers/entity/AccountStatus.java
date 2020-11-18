package team.jit.trainings.etl.customers.entity;

import java.text.MessageFormat;

public enum AccountStatus {
    ACTIVE("AKTYWNE"),
    INACTIVE("NIEAKTYWNE"),
    BLOCKED("ZABLOKOWANE")
    ;

    private String csvValue;

    AccountStatus(String csvValue) {
        this.csvValue = csvValue;
    }

    public static AccountStatus from(String csvValue) {
        for (AccountStatus value : AccountStatus.values()) {
            if (value.csvValue.equals(csvValue)) {
                return value;
            }
        }

        throw new IllegalArgumentException(MessageFormat.format("No such value = {0} in enum!", csvValue));
    }
}
