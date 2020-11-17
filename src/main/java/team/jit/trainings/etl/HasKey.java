package team.jit.trainings.etl;

import org.apache.commons.lang3.StringUtils;

public interface HasKey {

    String getKey();

    default String normalizeElement(String element) {
        return StringUtils.lowerCase(StringUtils.normalizeSpace(element));
    }
}
