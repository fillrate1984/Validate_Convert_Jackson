package com;

import com.converters.PersonConverter;
import com.models.Person;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

import static com.service.PersonService.initList;

@SpringBootApplication
public class App implements CommandLineRunner {

    Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("f:/jsons.txt")));
        PersonConverter converter = new PersonConverter();
        initList(converter.convert(json));
        Person person = new Person("3", "Wowa", "20");


        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        System.out.printf("Violations size = %d\n", violations.size());
        violations.forEach(x -> System.out.println(x.getMessage()));

    }
}
