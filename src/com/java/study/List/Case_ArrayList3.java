package com.java.study.List;

import java.util.ArrayList;

/**
 * 按照指定格式输出数组数据{元素1@元素2@}
 */
public class Case_ArrayList3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(20);
        list.add(14);
        list.add(18);
        printArrayList(list);

    }

    public static void printArrayList(ArrayList<Integer> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (i == list.size() - 1) {//判断是否为最后一个元素
                System.out.println(num + "}");
            } else {
                System.out.print(num + "@");

            }
        }
    }
}
