package com.gmail.dev.surovtsev.yaroslav;

import java.util.*;

public class Group {
    private List<Student> students = new ArrayList<>();
    private String name;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(Long recordВookNumber) {
        for (Student student : students) {
            if (student.getRecordВookNumber() == recordВookNumber) {
                students.remove(student);
                break;
            }
        }
    }

    public Student findStudent(String lastName) {
        for (Student student : students) {
            if (student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> sortStudentsByLastName() {
        List<Student> sortedGroup = new ArrayList<>(students);
        Collections.sort(sortedGroup, new StudentLastNameComparator());
        return sortedGroup;
    }

    public boolean checkUniqStudents() {
        Set<Student> studentsSet = new HashSet<Student>(students);
        return studentsSet.size() == students.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(students, group.students) && Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(students, name);
    }

    @Override
    public String toString() {
        List<Student> sortedGroup = sortStudentsByLastName();
        return "Group{" +
                "students=" + sortedGroup +
                ", name='" + name + '\'' +
                '}';
    }
}
