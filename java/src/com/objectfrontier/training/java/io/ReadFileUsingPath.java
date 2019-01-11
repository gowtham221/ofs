//Read a file using java.nio.Files using Paths

package com.objectfrontier.training.java.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFileUsingPath {

    public static void main(String[] args) throws IOException {

        ReadFileUsingPath.readFile();
    }

    private static void readFile() throws IOException {

        Path path = Paths.get("D:\\temp\\docs\\xanadu.txt");
        byte[] bytes = Files.readAllBytes(path);

        for (byte b : bytes) {
            System.out.print((char)b);
        }
    }
}
