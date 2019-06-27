package com.zs.filecenter.utils;

import java.util.Random;
import java.util.UUID;

public class UuidUtil {
    /**
     * uuid
     * @return
     */
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    /**
     * 返回长度为【strLength】的随机数，在前面补0
     */
    public static String getFixLenthString( int strLength ) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(1, strLength + 1);
    }

}
