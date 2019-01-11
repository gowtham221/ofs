// Write a program to get the number of files and number of directories in a given directory

package com.objectfrontier.training.java.io;

import java.io.File;
import java.util.Scanner;

public class CountFilesAndDirectories {

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        System.out.println("Please enter directory");
        String root = scanner.next();
        File file = new File(root);

        if (file.exists()) {
            int fileCount = 0;
            int dirCount = 0;
            File[] files = file.listFiles();

            for (File input : files) {

                if (input.isFile()) {
                    fileCount++;
                } else if (input.isDirectory()) {
                    dirCount++;
                }
            }

            System.out.println(fileCount);
            System.out.println(dirCount);
        }
    }
}
