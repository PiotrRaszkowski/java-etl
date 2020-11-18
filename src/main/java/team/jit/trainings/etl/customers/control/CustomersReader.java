package team.jit.trainings.etl.customers.control;

public interface CustomersReader {
    CustomersContainer readCustomers(String fileName);
}
