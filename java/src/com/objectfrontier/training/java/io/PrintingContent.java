package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PrintingContent {

    private static FileReader BufferReader;

    public static void main(String[] args) throws IOException {

        String path = "D://temp/docs/xanadu.txt";
        File file = new File(path);
        BufferReader = new FileReader(file);
        int character = 0;

        while ((character = BufferReader.read()) != -1) {

            System.out.print((char)character);
        }
    }
}
