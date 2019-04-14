package com.javase.study.String;

/**
 * 定义一个方法，把数组{1,2,3}按照指定格式拼接成一个字符串：[1Hai,2Hai,3Hai]。
 */
public class Case_String {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        String result = fromArrayToString(array);
        System.out.println(result);
    }

    public static String fromArrayToString(int[] array) {
        String str = "[";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                str += array[i] + "Hai]";
            } else {
                str += array[i] + "Hai,";

            }
        }
        return str;
    }
}
