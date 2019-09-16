package com.javase.study.List;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author：Haotian
 * @Date：2019/9/8 9:25
 */
public class TeacherManager {
    private static Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) {
        //使用集合储存教师数据
        ArrayList<Teacher> arrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            Teacher teacher = arrayList.get( i );
        }
        while (true) {
            System.out.println( "----------欢迎来到教师管理系统----------" );
            System.out.println( "1 添加教师" );
            System.out.println( "2 删除教师" );
            System.out.println( "3 修改教师" );
            System.out.println( "4 查看所有教师" );
            System.out.println( "5 退出系统" );
            System.out.println( "请选择您要进行的操作：" );
            String number = scanner.nextLine();
            switch (number) {
                case "1":
                    addTeacher( arrayList );
                    break;
                case "2":
                    deleteTeacher( arrayList );
                    break;
                case "3":
                    updateTeacher( arrayList );
                    break;
                case "4":
                    findAllTeacher( arrayList );
                    break;
                case "5":
                    System.out.println( "谢谢您的使用" );
                    //退出jvm
                    System.exit( 0 );
                default:
                    System.out.println( "您输入的指令有误" );
            }
        }

    }

    /**
     * 添加用户
     *
     * @param arrayList
     */
    private static void addTeacher(ArrayList<Teacher> arrayList) {
        String id = null;
        //账号存在，重新进行输入提示，通过break结束循环
        while (true) {
            System.out.println( "请输入您的账号：" );
            id = scanner.nextLine();
            boolean flag = isTid( arrayList, id );
            if (flag) {
                System.out.println( "您输入的账号已经存在，请重新输入" );
            } else {
                break;
            }
        }
        System.out.println( "请输入您的姓名：" );
        String name = scanner.nextLine();
        System.out.println( "请输入您的年龄：" );
        String age = scanner.nextLine();
        System.out.println( "请输入您的地址：" );
        String address = scanner.nextLine();
        Teacher teacher = insert( id, name, age, address );
        //将教师数据存入集合
        arrayList.add( teacher );
        System.out.println( "添加学生成功" );
    }

    /**
     * 查询所有用户
     *
     * @param arrayList
     */
    private static void findAllTeacher(ArrayList<Teacher> arrayList) {
        if (arrayList.size() == 0) {
            System.out.println( "暂无数据，请先添加数据" );
            return;
        }
        System.out.println( "账号" + "\t\t" + "姓名" + "\t\t" + "年龄" + "\t\t" + "居住地" );
        for (Teacher teacher : arrayList) {
            System.out.println( teacher.getId() + "\t\t" + teacher.getName() + "\t\t" + teacher.getAge() + "岁\t\t" + teacher.getAddress() );
        }
    }

    /**
     * 删除指定用户
     *
     * @param arrayList
     */
    private static void deleteTeacher(ArrayList<Teacher> arrayList) {
        System.out.println( "请输入您要删除的教师账号：" );
        String s = scanner.nextLine();
        for (Teacher t : arrayList) {
            if (t.getId().equals( s )) {
                arrayList.remove( t );
                System.out.println( "账号删除成功" );
                break;
            } else {
                System.out.println( "账号删除失败，请确认账号是否存在" );
                break;
            }
        }
    }

    /**
     * 修改用户信息
     *
     * @param arrayList
     */
    private static void updateTeacher(ArrayList<Teacher> arrayList) {
        String id = null;
        while (true) {
            System.out.println( "请输入您要修改的教师账号：" );
            id = scanner.nextLine();
            boolean flag = isTid( arrayList, id );
            if (!flag) {
                System.out.println( "您要进行修改的账号不存在，请核对后再次输入" );
            } else {
                break;
            }
        }
        while (true) {
            System.out.println( "请输入您的账号：" );
            id = scanner.nextLine();
            boolean flag = isTid( arrayList, id );
            if (flag) {
                System.out.println( "您输入的账号已经存在，请重新输入" );
            } else {
                break;
            }
        }
        System.out.println( "请输入您的新姓名：" );
        String name = scanner.nextLine();
        System.out.println( "请输入您的新年龄：" );
        String age = scanner.nextLine();
        System.out.println( "请输入您的新地址：" );
        String address = scanner.nextLine();
        Teacher teacher = insert( id, name, age, address );
        for (int i = 0; i < arrayList.size(); i++) {
            Teacher t = arrayList.get( i );
            if (t.getId().equals( id )) {
                arrayList.set( i, teacher );
                break;
            }
        }
        System.out.println( "更新教师信息成功" );
    }

    /**
     * 将数据存入成员变量返回
     *
     * @param id      用户账号
     * @param name    用户姓名
     * @param age     用户年龄
     * @param address 用户地址
     * @return 对应的用户对象
     */
    private static Teacher insert(String id, String name, String age, String address) {
        Teacher teacher = new Teacher();
        teacher.setId( id );
        teacher.setName( name );
        teacher.setAge( age );
        teacher.setAddress( address );
        return teacher;
    }

    /**
     * 用户账号过滤
     *
     * @param arrayList 用户数据
     * @param id        输入id
     * @return 用户账号是否存在
     */
    private static boolean isTid(ArrayList<Teacher> arrayList, String id) {
        boolean flag = false;
        for (Teacher t : arrayList) {
            //用户账号存在返回true
            if (t.getId().equals( id )) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
