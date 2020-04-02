package com.example.junit_605;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Junit605Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Junit605Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        new User("Jenya",35,Sex.MALE);
        new User("Vlad",17,Sex.MALE);
        new User("Marina",25,Sex.FEMALE);
        new User("Kristina",18,Sex.FEMALE);

        System.out.println("vse polzovateli");
        User.getAllUsers().forEach(System.out::println);
        System.out.println("vse polzovateli: MALE");
        User.getAllUsers(Sex.MALE).forEach(System.out::println);
        System.out.println("vse polzovateli: FEMALE");
        User.getAllUsers(Sex.FEMALE).forEach(System.out::println);
        System.out.println("====================================");
        System.out.println("       vsex polzovateley:" + User.getHowManyUsers());
        System.out.println("   vsex polzovateley:MALE" + User.getHowManyUsers(Sex.MALE));
        System.out.println(" vsex polzovateley:FEMALE" + User.getHowManyUsers(Sex.FEMALE));
        System.out.println("       общий возраст всех пользователей: " + User.getAllAgeUsers());
        System.out.println("  общий возраст всех пользователей MALE: " + User.getAllAgeUsers(Sex.MALE));
        System.out.println("общий возраст всех пользователей FEMALE: " + User.getAllAgeUsers(Sex.FEMALE));
        System.out.println("================================================");
        System.out.println("       средний возраст всех пользователей: " + User.getAverageAgeOfAllUsers());
        System.out.println("  средний возраст всех пользователей MALE: " + User.getAverageAgeOfAllUsers(Sex.MALE));
        System.out.println("средний возраст всех пользователей FEMALE: " + User.getAverageAgeOfAllUsers(Sex.FEMALE));
        System.out.println("================================================");
    }
}
