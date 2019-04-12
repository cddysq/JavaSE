package com.java.study.List;

import java.util.Objects;

/**
 * 学生对象
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals( name, student.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, age );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写排序规则
    @Override
    public int compareTo(Student o) {
        //return 0;认为元素都是相同的
        //自定义比较规则，比较两个人的年龄（this.参数Student）
        /**比价规则
         * this.getAge() - o.getAge()为升序
         * o.getAge() - this.getAge()为降序
         */
        return this.getAge() - o.getAge();//年龄升序
    }
}
