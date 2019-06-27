package com.zs.filecenter.utils;

public class FileUtil {

    public static String getFileExt(String filename) {
        int index = filename.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        String result = filename.substring(index + 1);
        return result;
    }
}
