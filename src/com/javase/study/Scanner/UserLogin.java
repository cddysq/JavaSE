package com.javase.study.Scanner;

import java.util.Scanner;

/**
 * @Author：Haotian
 * @Date：2019/9/7 13:50
 */
public class UserLogin {
    /**
     * 模拟用户数据
     */
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        //给定用户三次登录机会
        for (int i = 2; i >= 0; i--) {
            System.out.println( "请输入用户账号：" );
            String username = scanner.nextLine();
            System.out.println( "请输入用户密码：" );
            String password = scanner.nextLine();
            if (username.equals( USERNAME ) && password.equals( PASSWORD )) {
                System.out.println( "用户" + username + "登录成功" );
                break;
            } else {
                if (i == 0) {
                    System.out.println( "用户被锁定，请联系管理员处理" );
                } else {
                    System.out.println( "用户登录失败！当前还有" + i + "次机会" );
                }
            }
        }
    }
}
