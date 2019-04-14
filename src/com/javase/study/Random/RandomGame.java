package com.javase.study.Random;

import java.util.Random;
import java.util.Scanner;

/**
 * 模拟猜数字小游戏
 * 指定猜测次数，使用for循环
 */
public class RandomGame {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = r.nextInt(100) + 1;
        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("请输入您猜测的数字：");
            int guessNum = sc.nextInt();//键盘输入猜测的数字
            if (guessNum > randomNum){
                System.out.println("数字太大！请重试。");
            }else if (guessNum < randomNum){
                System.out.println("数字太小！请重试。");
            }else {
                System.out.println("恭喜你，猜中了！");
                break;//如果猜中，不再重试
            }
        }
        System.out.println("游戏结束。");
    }
}
