package com.gmail.dev.surovtsev.yaroslav;

import java.io.*;
import java.util.List;

public class GroupFileStorage {

    public static void saveGroupToSCV(Group gr) {
        File workFolder = new File("Groups");
        if (!workFolder.exists()) {
            workFolder.mkdir();
        }
        File fileCSV = new File(workFolder, gr.getName() + ".csv");
        String sep = ";";

        String groupName = gr.getName();
        List<Student> students = gr.getStudents();
        try (PrintWriter pw = new PrintWriter(fileCSV)) {
            pw.println(groupName + sep);
            for (Student student : students) {
                if (student == null) {
                    continue;
                }
                pw.println(student.toCSVString());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Group loadGroupFromCSV(File file) throws IOException {
        Group group = new Group();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            boolean firstLine = true;
            for (; ; ) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                if (firstLine) {
                    group.setName(line.replace(";", ""));
                    firstLine = false;
                    continue;
                }
                Student student = new Student().fromCSVString(line);
                group.addStudent(student);
            }
        } catch (IOException e) {
            throw e;
        }
        return group;
    }

    public static File findFileByGroupName(String groupName, File workFolder) {
        File[] files = workFolder.listFiles();
        for (File file : files) {
            String fileName = file.getName();
            String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
            if (fileNameWithoutExtension.equals(groupName)) {
                return file;
            }
        }
        return null;
    }
}
