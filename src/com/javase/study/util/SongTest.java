package com.javase.study.util;

/**
 * @Author：Haotian
 * @Date：2019/9/12 14:58
 */
public class SongTest {
    public static void main(String[] args) {
        Song[] arr = {
                new Song( "倩女幽魂", "怀旧", "张国荣" ),
                new Song( "年少有为", "流行", "李荣浩" ),
                new Song( "告白气球", "流行", "周杰伦" )};
        lookUp( arr, "流行" );
    }

    public static void lookUp(Song[] arr, String type) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getType().equals( type )) {
                arr[i].show();
            }
        }
    }
}
