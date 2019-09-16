package com.javase.study.List;

/**
 * @Author：Haotian
 * @Date：2019/9/10 10:51
 */
class Test {
    public static void main(String[] args) {
        /*int sum = 0;
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println( sum );*/
        int[] arr = {1, 3, 5};
        System.out.println( arr[0] );
        c( arr );
        System.out.println( arr[0] );
        System.out.println( "============================" );
        double num = 20.6;
        System.out.println( Math.round( num ) );
        System.out.println( "============================" );
        String a = "abc";
        String b = "abc";
        char[] chars = {'a', 'b', 'c'};
        String c = new String( chars );
        System.out.println( a == b );
        System.out.println( a == c );
        System.out.println( b == c );
        System.out.println( "============================" );
        int i = 10,j=25,x=30;
        switch (j-i){
            case 15:x++;
            case 16:x+=2;
            case 17:x+=3;
            default:--x;
        }
        System.out.println(x);
    }

    static void c(int[] arr) {
        arr[0] = 200;
    }

}