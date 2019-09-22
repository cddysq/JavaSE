package com.javase.study.InnerClass;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author：Haotian
 * @Date：2019/9/21 19:29
 */
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private Integer math;
    private Integer physics;

    public Integer getSum() {
        return math + physics;
    }
}
