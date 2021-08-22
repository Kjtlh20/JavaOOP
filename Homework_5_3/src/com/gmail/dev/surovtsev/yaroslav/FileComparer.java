package com.gmail.dev.surovtsev.yaroslav;

import java.io.*;

public class FileComparer {

    public static boolean compareFiles(File file1, File file2) throws IOException {
        boolean comparRes = true;
        if (!file1.exists() || !file2.exists()) {
            throw new FileNotFoundException("File not found");
        }
        int readBytes1 = 0;
        int readBytes2 = 0;
        byte[] buffer1 = new byte[10_1000_000];
        byte[] buffer2 = new byte[10_1000_000];
        try (InputStream is1 = new FileInputStream(file1);
             InputStream is2 = new FileInputStream(file2)) {
            for (; ; ) {
                readBytes1 = is1.read(buffer1);
                readBytes2 = is2.read(buffer2);
                for (int i = 0; i < buffer1.length; i++) {
                    if (buffer1[i] != buffer2[i]) {
                        comparRes = false;
                        break;
                    }
                }
                if (readBytes1 <= 0 && readBytes2 <= 0) {
                    break;
                }
            }
        } catch (IOException e) {
            throw e;
        }
        return comparRes;
    }
}
