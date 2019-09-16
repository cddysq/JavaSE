package com.javase.study.util;

import lombok.Data;

/**
 * @Author：Haotian
 * @Date：2019/9/12 14:55
 */
public class Song {
    private String name;
    private String type;
    private String singer;

    public Song() {
    }

    public Song(String name, String type, String singer) {
        this.name = name;
        this.type = type;
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void show() {
        System.out.println( "歌曲名：" + name + "/类型：" + type + "/演唱人：" + singer );

    }
}
