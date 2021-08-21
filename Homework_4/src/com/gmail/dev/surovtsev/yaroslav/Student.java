package com.gmail.dev.surovtsev.yaroslav;

public class Student extends Human implements CSVConverter {
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
    public String toCSVString() {
        String sep = ";";

        StringBuilder sb = new StringBuilder();
        sb.append(firstName.replace(sep, "")).append(sep);
        sb.append(lastName.replace(sep, "")).append(sep);
        sb.append(Integer.toString(age)).append(sep);
        sb.append(gender.toString()).append(sep);
        sb.append(Long.toString(recordВookNumber)).append(sep);
        sb.append(groupNumber.replace(sep, "")).append(sep);
        String CSVString = sb.toString();

        return CSVString;
    }

    @Override
    public Student fromCSVString(String str) {
        String sep = ";";

        String[] fieldsArray = str.split(sep);
        String firstName = fieldsArray[0];
        String lastName = fieldsArray[1];
        int age = Integer.parseInt(fieldsArray[2]);
        Gender gender = Gender.valueOf(fieldsArray[3]);
        long recordВookNumber = Long.parseLong(fieldsArray[4]);
        String groupNumber = fieldsArray[5];

        Student student = new Student(firstName, lastName, age, gender, recordВookNumber, groupNumber);

        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "recordВookNumber=" + recordВookNumber +
                ", groupNumber='" + groupNumber + '\'' +
                "} " + super.toString();
    }
}

