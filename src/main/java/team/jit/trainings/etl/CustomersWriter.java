package team.jit.trainings.etl;

import com.google.gson.Gson;

public class CustomersWriter {

    public void writeCustomers(CustomersContainer customersContainer) {
        Gson gson = new Gson();
        String toJson = gson.toJson(customersContainer.toList().get(0));
    }
}
