package team.jit.trainings.etl;

import org.junit.jupiter.api.Test;
import team.jit.trainings.etl.customers.entity.HasKey;

import static org.junit.jupiter.api.Assertions.*;

class HasKeyTest {

    @Test
    public void normalizeElementWhenCase1() {
        //GIVEN
        HasKey hasKey = new HasKey() {
            @Override
            public String getKey() {
                return null;
            }
        };

        //WHEN
        String result = hasKey.normalizeElement(" AbCd");

        //THEN
        assertEquals("abcd", result);
    }

    @Test
    public void normalizeElementWhenCase2() {
        //GIVEN
        HasKey hasKey = new HasKey() {
            @Override
            public String getKey() {
                return null;
            }
        };

        //WHEN
        String result = hasKey.normalizeElement(" abcd ");

        //THEN
        assertEquals("abcd", result);
    }

}