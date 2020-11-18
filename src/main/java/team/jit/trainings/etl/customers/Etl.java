package team.jit.trainings.etl.customers;

import team.jit.trainings.etl.customers.boundary.CustomersEtl;

public class Etl {
    public static void main(String[] args) {
        String sourceFileName = args[0];
        String destinationFileName = args[1];

        CustomersEtl customersEtl = new CustomersEtl();
        customersEtl.extractTransformAndLoad(sourceFileName, destinationFileName);
    }
}
