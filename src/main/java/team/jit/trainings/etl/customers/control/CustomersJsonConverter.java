package team.jit.trainings.etl.customers.control;

import com.google.gson.Gson;
import team.jit.trainings.etl.customers.entity.UnableToConvertException;

import java.io.Writer;

public class CustomersJsonConverter {

    public void convertToJson(CustomersContainer customersContainer, Writer writer) throws UnableToConvertException {
        Gson gson = new Gson();
        gson.toJson(customersContainer.toList(), writer);
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
////            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
////            objectMapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));
//            objectMapper.writeValue(writer, customersContainer.toList());
//        } catch (Exception e) {
//            throw new UnableToConvertException("Unable to convert to json due to unexpected error!", e);
//        }
    }
}
