package com.javase.study;


public class Clutter {

    public static void main(String[] args) {
        System.out.println("hello word !!!");
        char a= 'a';
        char A= 'A';
        char lin= '0';
        System.out.println(a+0);
        System.out.println(A+0);
        System.out.println(lin+0);
        System.out.println("============================");
        int result[] = calculate(10,20,30);
        System.out.println("main方法接收的地址值="+result);
        System.out.println("总和："+result[0]);
        System.out.println("平均数："+result[1]);
    }
    public static  int[] calculate(int a,int b,int c){
        int sum = a + b;//  求和
        int avg = sum / 3;//求平均数
        int[] array = {sum,avg};
        System.out.println(array);
        System.out.println("=============================");
        return  array;
    }
}