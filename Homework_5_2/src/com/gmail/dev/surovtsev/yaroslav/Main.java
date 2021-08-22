/* 2) Реализуйте отдельный класс GroupFileStorage в котором будут следующие методы:
 * ● void saveGroupToCSV(Group gr) — запись группы в CSV файл
 * ● Group loadGroupFromCSV(File file) — вычитка и возврат группы из файла
 * ● File findFileByGroupName(String groupName, File workFolder) — поиск файла в рабочем каталоге
 * (workFolder). Название файла определяется названием группы в нем сохраненной.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Y", "Y", 32, Gender.MALE, 12321323L, "PM-21");
        Student student2 = new Student("Y", "A", 32, Gender.MALE, 12321323L, "PM-21");
        Student student3 = new Student("Y", "Z", 32, Gender.MALE, 12321323L, "PM-21");
        Student student4 = new Student("Y", "B", 32, Gender.MALE, 12321323L, "PM-21");
        Student[] students = new Student[]{student1, student2, student3, student4};
        Group group = new Group("PM-21");
        for (Student student : students) {
            try {
                group.addStudent(student);
            } catch (GroupOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
        Group group2 = new Group("PM-22");
        for (Student student : students) {
            try {
                group2.addStudent(student);
            } catch (GroupOverflowException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(group);
        GroupFileStorage.saveGroupToSCV(group);
        GroupFileStorage.saveGroupToSCV(group2);
        File workFolder = new File("Groups");
        if (!workFolder.exists()) {
            workFolder.mkdir();
        }

        File file = new File(workFolder, group.getName() + ".csv");
        try {
            Group groupFromSCV = GroupFileStorage.loadGroupFromCSV(file);
            System.out.println(groupFromSCV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        File foundFile = GroupFileStorage.findFileByGroupName(group2.getName(), workFolder);
        System.out.println(foundFile);
    }
}
