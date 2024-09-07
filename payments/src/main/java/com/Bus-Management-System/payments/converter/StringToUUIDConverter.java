package com.tcs.payments.converter;

import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;
import org.springframework.core.convert.converter.Converter;
import com.fasterxml.jackson.databind.util.StdConverter;
public class StringToUUIDConverter implements Converter<String, UUID> {

    @Override
    public UUID convert(String source) {
        // Implement the logic to convert the string to a UUID
        try {
            return UUID.fromString(source);
        } catch (IllegalArgumentException e) {
            // Handle the exception if the string is not in the correct UUID format
            throw new IllegalArgumentException("Invalid UUID format: " + source);
        }
    }
}
