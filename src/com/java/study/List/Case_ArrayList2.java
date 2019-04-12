package com.java.study.List;

import java.util.ArrayList;

/**
 * 自定义四个学生对象，添加到集合并遍历
 */
public class Case_ArrayList2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        //为学生对象添加属性
        Student one = new Student("荒荒", 18);
        Student two = new Student("荒三荒", 3);
        Student three = new Student("叶迟荒", 22);
        Student four = new Student("琳琳", 21);

        //添加到集合
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        //遍历集合
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println("姓名：" + stu.getName() + "，年龄：" + stu.getAge());
        }

    }
}
