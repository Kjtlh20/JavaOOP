package com.gmail.dev.surovtsev.yaroslav;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Group {
    private Student[] students = new Student[10];
    private String name;

    public Group() {
    }

    public Group(String name) {
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

    public boolean checkUniqStudents() {
        boolean result = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                continue;
            }
            for (int j = 0; j < students.length; j++) {
                if (i == j) {
                    continue;
                }
                boolean temp = students[i].equals(students[j]);
                if (temp == true && students[i] != null && students[j] != null) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Arrays.equals(students, group.students) && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(students);
        return result;
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
