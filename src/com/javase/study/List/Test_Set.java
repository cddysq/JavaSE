package com.javase.study.List;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * java.util.Set接口 extends Collection接口
 * Set接口的特点：
 * 1.不允许储存重复的元素
 * 2.没有索引。没有带索引的方法，所以不能使用普通的for循环遍历
 * java.util.HashSet集合 implements Set接口
 * HashSet特点：
 * 3.是一个无序的集合，储存元素和取出元素的顺序可能不一致
 * 4.底层是一个哈希表结构（查询的速度非常快）
 * 拓展：LinkedHashSet相比HashSet多了一条链表，记录元素的储存顺序
 * <p>
 * 哈希值：是一个十进制的整数，由系统随机给出（是对象的逻辑地址值，不是数据的真实储存物理地址）
 * Object类中：public native int hashCode()可以返回对象的哈希码值，native代表该方法调用的本地操作系统方法。
 */
public class Test_Set {
    public static void main(String[] args) {

        int[] num = new int[]{3, 4, 5, 5, 2};
        //int数组转List
        List<Integer> list = Arrays.stream( num ).boxed().collect( Collectors.toList() );
        //List转Set
        Set<Integer> set = new HashSet<>( list );
        set.add( 1 );
        set.add( 2 );
        set.add( 3 );
        System.out.println( set );

        //自定义的对象使用HashSet集合需要重写HashCode，equals方法
        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add( new Student( "迟荒", 18 ) );
        hashSet.add( new Student( "迟荒", 18 ) );
        hashSet.add( new Student( "迷途", 16 ) );

        //sort排序规则只能在List列表中使用，需要进行列表转换
        List<Student> list2 = new ArrayList<>( hashSet );
        Collections.sort( list2 );
        System.out.println( hashSet );


        //使用可变参数求和
        System.out.println( "总和为=" + sum( 10, 20, 30, 40, 50 ) );

        //method();
    }

    //参数的类型确定，参数的个数不确定时，可以使用可变参数
    //一个方法参数列表只能有一个可变参数，并且当有多个参数时，可变参数需要放在最后
    public static int sum(int... i) {
        int num = 0;
        for (int sum : i) {

            //累加求和
            num += sum;
        }
        return num;
    }

    //使用Comparator重写排序规则
    @Test
    public void method() {
        List<Student> studentList = new ArrayList<>();
        studentList.add( new Student( "迟荒", 18 ) );
        studentList.add( new Student( "叶迟荒", 18 ) );
        studentList.add( new Student( "思涵", 20 ) );
        studentList.add( new Student( "少羽", 8 ) );
        Collections.sort( studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int resultAge = o1.getAge() - o2.getAge();
                int result = resultAge == 0 ? o1.getName().compareTo( o2.getName() ) : resultAge;
                return result;
            }
        } );
        System.out.println( studentList );
    }
}
