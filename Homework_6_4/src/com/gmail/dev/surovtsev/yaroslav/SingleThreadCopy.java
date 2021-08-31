package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;

public class SingleThreadCopy {

    public static void copyFilesSingleThread(File[] files, File folderFrom, File folderTo) {
        int size = files.length;
        int startIndex = 0;
        int endIndex = size;
        FilesArray task = new FilesArray(files, startIndex, endIndex, folderFrom, folderTo);
        Thread tread = task.getThread();
        try {
            tread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
