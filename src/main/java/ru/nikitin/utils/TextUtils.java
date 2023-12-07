package ru.nikitin.utils;

public class TextUtils {

    public static String setPathSuffix(String path, String suffix) {
        String[] str = path.split("\\.");
        String ret = "";
        ret = str[0] + "_" + suffix +"." + str[1];

        return ret;
    }
}
