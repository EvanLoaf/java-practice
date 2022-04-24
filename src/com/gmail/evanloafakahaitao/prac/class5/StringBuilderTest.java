package com.gmail.evanloafakahaitao.prac.class5;

import java.time.Duration;
import java.time.Instant;

public class StringBuilderTest {

    public static void main(String[] args) {
        String myStr = "gigastring";
        Instant ts1 = Instant.now();
        for (int i = 0; i < 10000; i++) {
            myStr += i;
        }
        Instant ts2 = Instant.now();
        System.out.println("String took " + Duration.between(ts1, ts2).toMillis());
        StringBuilder stringBuilder = new StringBuilder("uberstring");
        Instant ts3 = Instant.now();
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        Instant ts4 = Instant.now();
        System.out.println("StringBuilder took " + Duration.between(ts3, ts4).toMillis());
    }
}
