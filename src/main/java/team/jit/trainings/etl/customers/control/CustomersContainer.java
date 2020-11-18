package team.jit.trainings.etl.customers.control;

import team.jit.trainings.etl.customers.entity.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomersContainer {
    private Map<String, Customer> customers = new HashMap<>();

    public void add(Customer customer) {
        if (customers.containsKey(customer.getKey())) {
            customers.get(customer.getKey()).getAccounts().addAll(customer.getAccounts());
        } else {
            customers.put(customer.getKey(), customer);
        }
    }

    public int size() {
        return customers.size();
    }

    public List<Customer> toList() {
        return new ArrayList<>(customers.values());
    }
}
