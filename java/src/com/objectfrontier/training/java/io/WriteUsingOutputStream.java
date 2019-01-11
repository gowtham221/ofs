// Write some String content to a file using appropriate OutputStream

package com.objectfrontier.training.java.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteUsingOutputStream {

    public static void main(String[] args) throws IOException {

        String content = "This is example for write using output start";
        String path = "D://temp/docs/wirte.using.output.stream.txt";
        File file = new File(path);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int length = content.length();
        int i = 0;

        while (i < length) {
            System.out.print(content.charAt(i));
            fileOutputStream.write(content.charAt(i));
            i++;
        }

        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

}
