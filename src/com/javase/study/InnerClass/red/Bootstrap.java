package com.javase.study.InnerClass.red;

/**
 * 发红包场景说明：
 * 红包发出后，所有人都有红包，大家抢完后，最后一个给群主自己。
 * 红包策略:
 * 1.普通红包（平均）：totalMoney/totalCount,余数放在最后一个红包当中。
 * 2.手气红包（随机）：最少一分钱，最多不超过平均数的2倍。应该越发越少。
 */
public class Bootstrap {
    public static void main(String[] args) {
        MyRed red = new MyRed( "Mitu红包小程序" );
        //设置群主名称
        red.setOwnerName( "叶迟荒" );

        //普通红包
       /* OpenMode normal = new NormalMode();
        red.setOpenWay( normal );*/

        //手气红包
        OpenMode random = new RandomMode();
        red.setOpenWay( random );
    }
}
