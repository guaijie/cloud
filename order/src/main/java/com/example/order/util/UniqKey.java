package com.example.order.util;

import java.util.Random;

public class UniqKey {

    public static String genUniqKey(){
        Random random = new Random();

        Integer rn = random.nextInt(9000)+1000;

        return System.currentTimeMillis() + String.valueOf(rn);
    }
}
