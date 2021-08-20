/*1) Создайте класс, описывающий человека (создайте метод,
 * выводящий информацию о человеке).
 * 2) На его основе создайте класс студент (переопределите
 * метод вывода информации).
 * 3) Создайте класс Группа, который содержит массив из 10
 * объектов класса Студент. Реализуйте методы добавления,
 * удаления студента и метод поиска студента по фамилии. В
 * случае попытки добавления 11 студента, создайте
 * собственное исключение и обработайте его. Определите
 * метод toString() для группы так, что бы он выводил список
 * студентов в алфавитном порядке.
 * 4) * Нарисуйте UML диаграмму проекта.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Human human = new Human("Yaroslav", "Surovtsev", 32, Gender.MALE);
        System.out.println(human);

        Student student = new Student("Yaroslav", "Surovtsev", 32, Gender.MALE, 999888777333L, "21-C");
        System.out.println(student);

        Group group = new Group("21-C");
        System.out.println(group);

        try {
            group.addStudent(student);
            System.out.println(group);
        } catch (GroupOverflowException e) {
            System.out.println(e.getMessage());
        }

        Student foundStudent1 = group.findStudent("Yaroslav");
        if (foundStudent1 != null) {
            System.out.println(foundStudent1);
        }
        Student foundStudent2 = group.findStudent(student.lastName);
        if (foundStudent2 != null) {
            System.out.println(foundStudent2);
        }

        group.deleteStudent(999888777333L);
        System.out.println(group);

        for (int i = 0; i < 11; i++) {
            try {
                group.addStudent(student);
                System.out.println(group);
            } catch (GroupOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
