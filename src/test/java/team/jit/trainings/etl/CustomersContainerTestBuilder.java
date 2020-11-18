package team.jit.trainings.etl;

import team.jit.trainings.etl.customers.control.CustomersContainer;

public class CustomersContainerTestBuilder {

    private CustomerTestBuilder customerTestBuilder = new CustomerTestBuilder();

    public CustomersContainer withSingleCustomer() {
        CustomersContainer customersContainer = new CustomersContainer();

        customersContainer.add(customerTestBuilder.newFullCustomer());

        return customersContainer;
    }

    public CustomersContainer withMultipleCustomer() {
        CustomersContainer customersContainer = new CustomersContainer();

        customersContainer.add(customerTestBuilder.newFullCustomer("Jan", "Nowak"));
        customersContainer.add(customerTestBuilder.newFullCustomer("Adam", "Kowalski"));

        return customersContainer;
    }
}
