//Write a program to check if two paths are same.

package com.objectfrontier.training.java.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathCheck {

    private static Scanner scanner;

    public static void main(String[] args) {

        PathCheck.pathCheck();
    }

    private static void pathCheck() {

        scanner = new Scanner(System.in);
        String inputFirstPath = scanner.next();
        String inputSecondPath = scanner.next();

        Path firstPath = Paths.get(inputFirstPath);
        Path secondPath = Paths.get(inputSecondPath);

        File fileOne = firstPath.toFile();
        File fileTwo = firstPath.toFile();

        if (fileOne.exists() && fileTwo.exists()) {

            int check = firstPath.compareTo(secondPath);

            if (check == 0) {
                System.out.println("Two Paths are same");
            } else {
                System.out.println("Two Paths are not same");
            }
        }
    }
}
