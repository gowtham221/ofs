// Print the Epoch time

package com.objectfrontier.training.java.datetime;

import java.time.Clock;

public class EpochTime {

    public static void main(String[] args) {

        EpochTime e = new EpochTime();
        long epochTime = e.getEpochTime();
        print(epochTime);
    }

    private long getEpochTime() {

        Clock clock = Clock.systemUTC();
        long epochTime = clock.millis();
        return epochTime;
    }

    private static void print(long epochTime) {

        System.out.println(epochTime);
    }
}
