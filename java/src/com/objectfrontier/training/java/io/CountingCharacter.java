package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountingCharacter {

    private static FileReader BufferReader;

    public static void main(String[] args) throws IOException {

        String path = "D://temp/docs/xanadu.txt";
        File file = new File(path);
        BufferReader = new FileReader(file);
        int character = 0;
        int count = 0;
        int numericEquals = args[0].charAt(0);

        while ((character = BufferReader.read()) != -1) {

            if (character == numericEquals) { count++; }
        }

        System.out.println(count);
    }

}
