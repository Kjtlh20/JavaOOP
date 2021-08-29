/* Модифицируйте класс «Группа» для более удобных методов работы с динамическими массивами.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Y", "Y", 32, Gender.MALE, 111L, "PM-20");
        Student student2 = new Student("Y", "A", 32, Gender.MALE, 222L, "PM-20");
        Student student3 = new Student("Y", "Z", 32, Gender.MALE, 333L, "PM-20");
        Student student4 = new Student("Y", "B", 32, Gender.MALE, 444L, "PM-20");
        Student student5 = new Student("Y", "Y", 32, Gender.MALE, 111L, "PM-20");
        Group group1 = new Group("PM-20");
        group1.addStudent(student1);
        group1.addStudent(student2);
        group1.addStudent(student3);
        group1.addStudent(student4);
        System.out.println(group1);

        group1.deleteStudent(student4.getRecordВookNumber());
        System.out.println(group1);

        System.out.println(group1.findStudent("Z"));

        System.out.println(group1.checkUniqStudents());
        group1.addStudent(student5);
        System.out.println(group1.checkUniqStudents());
    }
}
