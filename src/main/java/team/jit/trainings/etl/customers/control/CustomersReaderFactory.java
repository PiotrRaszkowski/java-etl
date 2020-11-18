package team.jit.trainings.etl.customers.control;

public final class CustomersReaderFactory {
    private CustomersReaderFactory() {
    }

    public static CustomersReader newCustomersReader(CustomersReaderType readerType) {
        return switch (readerType) {
            case CSV -> new CSVCustomersReader();
            case TXT -> new TXTCustomersReader();
        };
    }
}
