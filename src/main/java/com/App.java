package com;

import com.converters.PersonConverter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String json = new String(Files.readAllBytes(Paths.get("f:/jsons.txt")));
        PersonConverter converter = new PersonConverter()
        System.out.println(json);
    }
}
