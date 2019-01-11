// Create and print the time stamp for current date

package com.objectfrontier.training.java.datetime;

import java.sql.Timestamp;

public class PrintTimeStamp {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        Timestamp timeStamp = new Timestamp(time);
        System.out.println(timeStamp);
    }
}
