package com.service;

import com.models.Person;

import java.util.List;
import java.util.Optional;

public class PersonService {

    private static List<Person> persons;


    public static void initList(List<Person> personList) {
        persons = personList;
    }

    public static void printAll() {
        persons.forEach(System.out::println);
    }

    public static List<Person> getPersons() {
        return persons;
    }

    public static Optional<Person> getById(String id) {

        return persons.stream().filter(x -> x.getId().equals(id)).findFirst();
    }
}
