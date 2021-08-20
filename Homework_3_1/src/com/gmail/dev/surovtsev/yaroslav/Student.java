package com.gmail.dev.surovtsev.yaroslav;

public class Student extends Human {
    private long recordВookNumber;
    private String groupNumber;

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, int age, Gender gender, long recordВookNumber, String groupNumber) {
        super(firstName, lastName, age, gender);
        this.recordВookNumber = recordВookNumber;
        this.groupNumber = groupNumber;
    }

    public long getRecordВookNumber() {
        return recordВookNumber;
    }

    public void setRecordВookNumber(long recordВookNumber) {
        this.recordВookNumber = recordВookNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "recordВookNumber=" + recordВookNumber +
                ", groupNumber='" + groupNumber + '\'' +
                "} " + super.toString();
    }
}

