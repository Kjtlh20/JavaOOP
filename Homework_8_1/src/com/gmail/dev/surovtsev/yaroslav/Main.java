/* 1) Реализуйте корректные методы equals, hashCode для классов Человек, Студент и Группа.
 * 2) Реализуйте вспомогательный метод для проверки факта отсутствия эквивалентных студентов в
 * группе.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Human human1 = new Human("Yaroslav", "Surovtsev", 32, Gender.MALE);
        Human human2 = new Human("Yaroslav", "Surovtsev", 32, Gender.MALE);
        Human human3 = new Human("Yaroslav2", "Surovtsev", 32, Gender.MALE);
        int hashCodeHuman1 = human1.hashCode();
        int hashCodeHuman2 = human2.hashCode();
        int hashCodeHuman3 = human3.hashCode();
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        System.out.println("hashCodeHuman1: " + hashCodeHuman1);
        System.out.println("hashCodeHuman2: " + hashCodeHuman2);
        System.out.println("hashCodeHuman3: " + hashCodeHuman3);
        System.out.println("hashCodeHuman1 == hashCodeHuman2: " + (hashCodeHuman1 == hashCodeHuman2));
        System.out.println("hashCodeHuman3 == hashCodeHuman2: " + (hashCodeHuman3 == hashCodeHuman2));
        System.out.println("human1.equals(human2): " + human1.equals(human2));
        System.out.println("human2.equals(human1): " + human2.equals(human1));
        System.out.println("human3.equals(human1): " + human3.equals(human1));
        System.out.println("human1.equals(human3): " + human1.equals(human3));
        System.out.println("----------------------------------------------------------------------");
        Student student1 = new Student("Yaroslav", "Surovtsev", 32, Gender.MALE, 987654321L, "PM-3");
        Student student2 = new Student("Yaroslav", "Surovtsev", 32, Gender.MALE, 987654321L, "PM-3");
        Student student3 = new Student("Yaroslav2", "Surovtsev", 32, Gender.MALE, 987654321L, "PM-3");
        int hashCodeStudent1 = student1.hashCode();
        int hashCodeStudent2 = student2.hashCode();
        int hashCodeStudent3 = student3.hashCode();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);
        System.out.println("hashCodeStudent1: " + hashCodeStudent1);
        System.out.println("hashCodeStudent2: " + hashCodeStudent2);
        System.out.println("hashCodeStudent3: " + hashCodeStudent3);
        System.out.println("hashCodeStudent1 == hashCodeStudent2: " + (hashCodeStudent1 == hashCodeStudent2));
        System.out.println("hashCodeStudent3 == hashCodeStudent2: " + (hashCodeStudent3 == hashCodeStudent2));
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println("student2.equals(student1): " + student2.equals(student1));
        System.out.println("student3.equals(student1): " + student3.equals(student1));
        System.out.println("student1.equals(student3): " + student1.equals(student3));
        System.out.println("----------------------------------------------------------------------");
        Group group1 = new Group("PM-3");
        try {
            group1.addStudent(student1);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        Group group2 = new Group("PM-3");
        try {
            group2.addStudent(student1);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        int hashCodeGroup1 = group1.hashCode();
        int hashCodeGroup2 = group2.hashCode();
        System.out.println(group1);
        System.out.println(group2);
        System.out.println("hashCodeGroup1: " + hashCodeGroup1);
        System.out.println("hashCodeGroup2: " + hashCodeGroup2);
        System.out.println("hashCodeGroup1 == hashCodeGroup2: " + (hashCodeGroup1 == hashCodeGroup2));
        System.out.println("group1.equals(group2): " + group1.equals(group2));
        System.out.println("group2.equals(group1): " + group2.equals(group1));
        System.out.println("----------------------------------------------------------------------");
        try {
            group2.addStudent(student2);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        hashCodeGroup1 = group1.hashCode();
        hashCodeGroup2 = group2.hashCode();
        System.out.println(group1);
        System.out.println(group2);
        System.out.println("hashCodeGroup1: " + hashCodeGroup1);
        System.out.println("hashCodeGroup2: " + hashCodeGroup2);
        System.out.println("hashCodeGroup1 == hashCodeGroup2: " + (hashCodeGroup1 == hashCodeGroup2));
        System.out.println("group1.equals(group2): " + group1.equals(group2));
        System.out.println("group2.equals(group1): " + group2.equals(group1));
        System.out.println("----------------------------------------------------------------------");
        System.out.println("group1.checkUniqStudents(): " + group1.checkUniqStudents());
        System.out.println("group2.checkUniqStudents(): " + group2.checkUniqStudents());
        group2.deleteStudent(987654321L);
        System.out.println("group2.checkUniqStudents(): " + group2.checkUniqStudents());
        try {
            group2.addStudent(student3);
        } catch (GroupOverflowException e) {
            e.printStackTrace();
        }
        System.out.println("group2.checkUniqStudents(): " + group2.checkUniqStudents());
    }
}
