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

    public static void copyFileFromTo(File file, File folderFrom, File folderTo) throws IOException {
        if (!folderFrom.exists() || !folderTo.exists()) {
            throw new IllegalArgumentException();
        }
        File out = new File(folderTo, file.getName());
        copyFile(file, out);
    }
}
