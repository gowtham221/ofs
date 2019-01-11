// Given a path, check if path is file or directory

package com.objectfrontier.training.java.io;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckPath {

    public static void main(String[] args) {

        CheckPath.isDirectory();
        CheckPath.isFile();
    }

    private static void isDirectory() {

        // Path path = getPath();
        Path path = Paths.get("D:\\temp\\docs");

        // print(isDirectory(path));
        System.out.println(Files.isDirectory(path));
    }

    private static void isFile() {

        // Path path = getPath();
        File path = new File("D:\\temp\\docs");

        // print(isFile(path));
        System.out.println(path.isFile());
    }
}
