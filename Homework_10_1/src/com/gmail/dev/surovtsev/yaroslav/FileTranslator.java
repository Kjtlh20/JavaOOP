package com.gmail.dev.surovtsev.yaroslav;

import java.io.*;
import java.util.Map;

public class FileTranslator {
    private File fileIn;
    private File fileOut;
    private Map<String, String> dict;

    public FileTranslator() {
    }

    public FileTranslator(File fileIn, File fileOut, Map<String, String> dict) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
        this.dict = dict;
    }

    public File getFileIn() {
        return fileIn;
    }

    public void setFileIn(File fileIn) {
        this.fileIn = fileIn;
    }

    public File getFileOut() {
        return fileOut;
    }

    public void setFileOut(File fileOut) {
        this.fileOut = fileOut;
    }

    public Map<String, String> getDict() {
        return dict;
    }

    public void setDict(Map<String, String> dict) {
        this.dict = dict;
    }

    public void translate() {
        if (!fileIn.exists()) {
            return;
        }
        if (!fileOut.exists()) {
            fileOut = new File("files_translator/", "Ukrainian.out.csv");
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String sep = ";";
        try (BufferedReader br = new BufferedReader(new FileReader(fileIn));
             PrintWriter pw = new PrintWriter(fileOut)) {
            String line;
            for (; ; ) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String key = line.replace(sep, "");
                String value = dict.get(key);
                if (value == null) {
                    value = "translation not found";
                }
                pw.println(value + sep);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "FileTranslator{" +
                "fileIn=" + fileIn +
                ", fileOut=" + fileOut +
                ", dict=" + dict +
                '}';
    }
}
