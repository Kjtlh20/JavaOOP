/* 1) Дополните реализацию группы Студентов (задание прошлой лекции) возможностью сортировки
 * массива студентов по фамилии. Для этого в класс Группа добавьте метод
 * sortStudentsByLastName().
 * 2) Создайте отдельный класс который реализует считывание характеристик студента с клавиатуры
 * (имя, фамилии и т. д.). Создание и возврат студента на основе считанных данных. Используете
 * методы этого класса для считывания и добавления студента в группу
 * 3) Объявите интерфейс
 * public interface CSVConverter{
 *  public String toCSVString();
 *  public Student fromCSVString (String str);
 * }
 * Класс Студент должен реализовывать этот интерфейс. Логика реализации следующая — на
 * основе Студента создать строку с его CSV представлением и наоборот на основе этой строки
 * создать Студента.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Y", "Y", 32, Gender.MALE, 12321323L, "MC-5");
        Student student2 = new Student("Y", "A", 32, Gender.MALE, 12321323L, "MC-5");
        Student student3 = new Student("Y", "Z", 32, Gender.MALE, 12321323L, "MC-5");
        Student student4 = new Student("Y", "B", 32, Gender.MALE, 12321323L, "MC-5");
        Student[] students = new Student[]{student1, student2, student3, student4};
        Group group = new Group("MC-5");
        for (Student student : students) {
            try {
                group.addStudent(student);
            } catch (GroupOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(group);

        StudentCreator studentCreator = new StudentCreator();
        Student newStudent = studentCreator.createStudent();
        System.out.println(newStudent);
        try {
            group.addStudent(newStudent);
        } catch (GroupOverflowException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(group);

        String CSVString = newStudent.toCSVString();
        System.out.println(CSVString);
        Student studentFromCSV = new Student().fromCSVString(CSVString);
        System.out.println(studentFromCSV);
    }
}
