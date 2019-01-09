package com.converters;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.models.Person;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PersonConverter implements Converter<String, List<Person>> {

    Logger logger = Logger.getLogger(PersonConverter.class);

    @Override
    public List<Person> convert(String json) {
        logger.info("Converting");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, new TypeReference<List<Person>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
