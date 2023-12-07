package ru.nikitin.utils;

public class MathUtil {

    public static boolean isAllTrue(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == false) {
                return false;
            }
        }
        return true;
    }
}
