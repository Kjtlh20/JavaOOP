package com.gmail.dev.surovtsev.yaroslav;

import java.io.*;

public class FileCopyService {

    public static void copyFile(File in, File out) throws IOException {
        byte[] buffer = new byte[10_000_000];
        int readBytes = 0;

        try (InputStream is = new FileInputStream(in);
             OutputStream os = new FileOutputStream(out)) {

            for (; ; ) {
                readBytes = is.read(buffer);
                if (readBytes <= 0) {
                    break;
                }
                os.write(buffer, 0, readBytes);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFolder(File folderFrom, File folderTo) throws IOException {
        if (!folderFrom.exists() || !folderTo.exists()) {
            throw new IllegalArgumentException();
        }
        File[] files = folderFrom.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                File out = new File(folderTo, files[i].getName());
                copyFile(files[i], out);
            }
        }
    }

    public static void copyDocFiles(File folderFrom, File folderTo) throws IOException {
        if (!folderFrom.exists() || !folderTo.exists()) {
            throw new IllegalArgumentException();
        }
        File[] files = folderFrom.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && checkDocFileExtension(files[i].getName())) {
                File out = new File(folderTo, files[i].getName());
                copyFile(files[i], out);
            }
        }
    }

    public static boolean checkDocFileExtension(String fileName) {
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index >= 0) {
            extension = fileName.substring(index + 1);
        }
        return extension.toUpperCase().contains("doc".toUpperCase());
    }
}
