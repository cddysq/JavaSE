package com.javase.study.InnerClass;

import java.util.TreeSet;

/**
 * @Author：Haotian
 * @Date：2019/9/21 19:31
 */
public class StudentSort {
    public static void main(String[] args) {
        /**
         * 成绩降序排
         */
        TreeSet<Student> treeSet = new TreeSet<>( (o1, o2) -> {
            int sum = o2.getSum() - o1.getSum();
            int math = sum == 0 ? o1.getMath() - o2.getMath() : sum;
            return math == 0 ? o1.getName().compareTo( o2.getName() ) : math;
        } );
        Student s1 = new Student( "学员一号", 98, 100 );
        Student s2 = new Student( "学员二号", 100, 100 );
        Student s3 = new Student( "学员三号", 60, 73 );
        Student s4 = new Student( "学员四号", 80, 74 );
        Student s5 = new Student( "学员五号", 74, 80 );
        Student s6 = new Student( "学员六号", 74, 80 );
        treeSet.add( s1 );
        treeSet.add( s2 );
        treeSet.add( s3 );
        treeSet.add( s4 );
        treeSet.add( s5 );
        treeSet.add( s6 );
        treeSet.forEach( System.out::println );
        Integer.valueOf( 100 );
    }
}
