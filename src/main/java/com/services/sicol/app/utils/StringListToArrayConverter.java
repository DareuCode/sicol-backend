package com.services.sicol.app.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class StringListToArrayConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        // Convertir la lista de Strings en un formato adecuado para PostgreSQL TEXT[]
        return "{" + attribute.stream().collect(Collectors.joining(",")) + "}";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        // Convertir el string del formato PostgreSQL TEXT[] a una lista de Strings
        return Arrays.asList(dbData.replace("{", "").replace("}", "").split(","));
    }
}
