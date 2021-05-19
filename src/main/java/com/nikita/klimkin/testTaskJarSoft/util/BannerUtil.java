package com.nikita.klimkin.testTaskJarSoft.util;

import java.util.Random;

public class BannerUtil {

    public static int getRandomIndexOfList(int lengthOfList) {
        Random random = new Random();
        return random.nextInt(lengthOfList);
    }
}
