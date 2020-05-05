package org.test.Imdb;

import java.util.Random;

public class Utility {

    public static int random(int min, int max) {
        if (max > min) {
            Random rand = new Random();
            return rand.ints(min, max).findFirst().getAsInt();
        }
        throw new RuntimeException("Index value is out of range");
    }

    public static void delay(int msTime) {
        try {
            java.lang.Thread.sleep(msTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
