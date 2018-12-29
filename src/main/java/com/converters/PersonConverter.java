package com.converters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Person;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@AllArgsConstructor

public class PersonConverter implements Converter<String, Person> {

    Logger logger;

    @Override
    public Person convert(String json) {
        logger.info("Converting");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
