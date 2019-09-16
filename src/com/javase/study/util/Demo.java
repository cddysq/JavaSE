package com.javase.study.util;

import java.util.ArrayList;

/**
 * @Author：Haotian
 * @Date：2019/9/14 19:28
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(100);
        list.add(200);
        list.add(300);
        ArrayList<Integer> newList = changeList(list);
        for (int i = 0; i < newList.size(); i++) {
            System.out.print(newList.get(i)+" ");
        }
    }
    public static ArrayList<Integer> changeList(ArrayList<Integer> arr) {
        for (int i = 0; i < 3; i++) {
            arr.add(666);
        }
        return arr;
    }
}