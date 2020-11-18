package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.boundary.CustomersEtl;

import java.io.File;
import java.io.IOException;

class CustomersEtlTest {

    private CustomersEtl customersEtl = new CustomersEtl();

    @Test
    public void extractTransformAndLoad() throws IOException {
        //GIVEN
        File sourceFile = new File("src/test/resources/customers.csv");
//        Path destinationFile = Files.createTempFile("customers", ".json");

        //WHEN
        customersEtl.extractTransformAndLoad(sourceFile.getPath(), "customers.json");

        //THEN
    }
}