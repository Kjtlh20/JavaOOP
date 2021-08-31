package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;

public class MultiThreadCopy {

    public static void copyFilesMultiThread(File[] files, File folderFrom, File folderTo) {
        int threadCount = Runtime.getRuntime().availableProcessors();
        System.out.println("threadCount: " + threadCount);
        int size = files.length / threadCount;
        if (size < 1) {
            size = 1;
        }
        if (threadCount > size) {
            threadCount = size;
        }
        FilesArray[] tasks = new FilesArray[threadCount];
        Thread[] treads = new Thread[threadCount];

        int startIndex = 0;
        int endIndex = size;
        for (int i = 0; i < tasks.length; i++) {
            if (i == tasks.length - 1) {
                endIndex = files.length;
            }
            tasks[i] = new FilesArray(files, startIndex, endIndex, folderFrom, folderTo);
            treads[i] = tasks[i].getThread();
            startIndex = startIndex + size;
            endIndex = endIndex + size;
        }
        for (int i = 0; i < treads.length; i++) {
            try {
                treads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
