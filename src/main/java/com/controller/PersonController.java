package com.controller;

import com.models.Person;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@RestController
public class PersonController {


    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public String index(@Valid @RequestBody Person person) {
        Validator validator = validatorFactory.getValidator();
        System.out.println(validator);
        //violations.forEach(System.out::println);
        System.out.println(person);
        return "Hello";
    }
}
