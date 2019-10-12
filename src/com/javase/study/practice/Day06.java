package com.javase.study.practice;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author：Haotian
 * @Date：2019/10/12 18:38
 */
public class Day06 {

    public static void main(String[] args) {
        /*
       	使用lambda表达式分别将以下功能封装到Function对象中
            求Integer类型ArrayList中所有元素的平均数
            将Map<String,Integer>中value存到ArrayList<Integer>中
         */
        Function<ArrayList<Integer>, Integer> f1 = (list) -> {
            Integer sum = 0;
            for (Integer i : list) {
                sum += i;
            }
            return sum / list.size();
        };

        Function<Map<String, Integer>, ArrayList<Integer>> f2 = (map) -> {
            Collection<Integer> values = map.values();
            return new ArrayList<>( values );
        };

        Map<String, Integer> map = new HashMap<>( 100 );
        map.put( "岑小村", 59 );
        map.put( "谷天洛", 82 );
        map.put( "渣渣辉", 98 );
        map.put( "蓝小月", 65 );
        map.put( "皮几万", 70 );

        //利用Function求平均成绩
        Integer avg = f2.andThen( f1 ).apply( map );
        System.out.println( "学生平均成绩为：" + avg );
    }

    @Test
    public void convert() {
        List<String> man = new ArrayList<>();
        man.add( "男一" );
        man.add( "男二" );
        man.add( "男三号" );
        man.add( "男四" );
        man.add( "男五" );
        man.add( "男六" );

        List<String> female = new ArrayList<>();
        female.add( "女一" );
        female.add( "女二" );
        female.add( "女三" );
        female.add( "林女四" );
        female.add( "女五" );
        female.add( "林女六" );

        /*现在有两个ArrayList集合，分别存储6名男演员名称和6名女演员名称，要求完成如下的操作:
           男演员只要名字为3个字的前三人
           女演员只要姓林的，并且不要第一个
           把过滤后的男演员姓名和女演员姓名合并到一起
           把上一步操作后的元素作为构造方法的参数创建演员对象,遍历数据*/
        Stream.concat( man.stream().filter( name -> name.length() == 3 ).limit( 3 ),
                female.stream().filter( name -> name.startsWith( "林" ) ).skip( 1 ) ).
                map( Actor::new ).forEach( System.out::println );
    }

    @Test
    public void filterName() {
        /*有如下7个元素黄药师，冯蘅，郭靖，黄蓉，郭芙，郭襄，郭破虏，使用Stream将以郭字开头的元素存入新数组*/
        String[] array = Stream.of( "黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏" ).filter( name -> name.startsWith( "郭" ) ).toArray( String[]::new );
        Stream.of( array ).forEach( System.out::println );
    }

    @Test
    public void abs() {
        /*取绝对值*/
        Stream.of( -1, 5, -2, 3 ).map( Math::abs ).forEach( System.out::println );
    }

    @Test
    public void collect() {
        /*已知数组arr1中有如下元素{郭靖，杨康}，arr2中有如下元素{黄蓉，穆念慈}，使用Stream将二者合并到List集合*/
        String[] arr1 = {"郭靖", "杨康"};
        String[] arr2 = {"黄蓉", "穆念慈"};
        List<String> list = Stream.concat( Stream.of( arr1 ), Stream.of( arr2 ) ).collect( Collectors.toList() );
        System.out.println( list );
    }

}
