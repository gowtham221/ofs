package com.objectfrontier.training.java.datetime;

import java.time.LocalTime;

public class CurrentTime {

    public static void main(String[] args) {

        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time is : " + currentTime);
    }
}
