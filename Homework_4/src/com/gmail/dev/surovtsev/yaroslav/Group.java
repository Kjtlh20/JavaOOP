package com.gmail.dev.surovtsev.yaroslav;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private Student[] students;
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.students = new Student[10];
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) throws GroupOverflowException {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        throw new GroupOverflowException();
    }

    public void deleteStudent(Long recordВookNumber) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getRecordВookNumber() == recordВookNumber) {
                students[i] = null;
                break;
            }
        }
    }

    public Student findStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getLastName().equals(lastName)) {
                return students[i];
            }
        }
        return null;
    }

    public Student[] sortStudentsByLastName() {
        Student[] sortedGroup = Arrays.copyOf(students, students.length);
        Arrays.sort(sortedGroup, Comparator.nullsFirst(new StudentLastNameComparator()));
        return sortedGroup;
    }

    @Override
    public String toString() {
        Student[] sortedGroup = sortStudentsByLastName();
        return "Group{" +
                "students=" + Arrays.toString(sortedGroup) +
                ", name='" + name + '\'' +
                '}';
    }
}
