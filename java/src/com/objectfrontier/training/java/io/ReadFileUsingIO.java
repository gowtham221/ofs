//Read a file using java.io.File

package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingIO {

    private static FileReader fileReader;

    public static void main(String[] args) throws IOException {

        String path = "D:\\temp\\docs\\xanadu.txt";
        File file = new File(path);
        fileReader = new FileReader(file);
        int z = 0;

        while (( z = fileReader.read()) != -1) {
            System.out.print((char)z);
        }
    }

}
