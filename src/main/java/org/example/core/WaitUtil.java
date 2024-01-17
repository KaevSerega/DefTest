package org.example.core;


import java.time.Duration;

public class WaitUtil {

    private WaitUtil() {
    }

    public static void sleep(Duration duration) {
        try {
            long milliseconds = duration.toMillis();
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


