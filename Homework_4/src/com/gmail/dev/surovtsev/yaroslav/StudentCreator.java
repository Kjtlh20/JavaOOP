package com.gmail.dev.surovtsev.yaroslav;

import java.util.Locale;
import java.util.Scanner;

public class StudentCreator {

    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to student creator");

        System.out.println("Enter firstname");
        String firstname = sc.nextLine();

        System.out.println("Enter lastname");
        String lastname = sc.nextLine();

        System.out.println("Enter age");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter gender(Male, Female, Mixed)");
        String asd = sc.nextLine();
        Gender gender = Gender.valueOf(asd.toUpperCase());

        System.out.println("Enter record book number");
        long recordВookNumber = sc.nextLong();
        sc.nextLine();

        System.out.println("Enter group number");
        String groupNumber = sc.nextLine();

        Student student = new Student(firstname, lastname, age, gender, recordВookNumber, groupNumber);

        System.out.println("Thank you, you have created a student");

        return student;
    }
}
