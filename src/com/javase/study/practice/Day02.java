package com.javase.study.practice;

import java.util.* ;

/**
 * @Author：Haotian
 * @Date：2019/9/25 18:30
 */
public class Day02 {
    public static void main(String[] args) {
        rBall();
        Scanner scanner = new Scanner( System.in );
        System.out.println( "请输入字符进行去重排序：" );
        String next = scanner.next();
        compare( next );
    }

    /**
     * 键盘录入一个字符串，去掉其中重复字符，打印出不同的那些字符，必须保证顺序。例如输入：aaaabbbcccddd，打印结果为：abcd。
     */
    private static void compare(String next) {
        Set<Character> set = new HashSet<>();
        char[] a = next.toCharArray();
        for (char c : a) {
            set.add( c );
        }
        ArrayList<Character> list = new ArrayList<>( set );
        Collections.sort( list );
        System.out.println( list );
    }

    /**
     * 双色球规则：双色球每注投注号码由6个红色球号码和1个蓝色球号码组成。红色球号码从1—33中选择；蓝色球号码从1—16中选择；请随机生成一注双色球号码。（要求同色号码不重复）
     */
    private static void rBall() {
        Random random = new Random();
        Set<Integer> ball = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            ball.add( random.nextInt( 33 ) + 1 );
        }
        ball.add( random.nextInt( 16 ) + 1 );
        System.out.println( ball );
    }
}
