package com.javase.study.File;

import com.javase.study.Random.RandomGame;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @Author：Haotian
 * @Date：2019/10/7 18:30
 */
public class GuessTheNumber {
    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        FileReader reader = new FileReader( "resources/count" );
        p.load( reader );
        reader.close();
        String number = p.getProperty( "count" );
        int count = Integer.parseInt( number );
        if (count > 1) {
            System.out.println( "游戏体验次数已用尽，请充值后继续" );
        } else {
            RandomGame.start();
            count++;
            p.setProperty( "count", String.valueOf( count ) );
            FileWriter writer = new FileWriter( "resources/count" );
            p.store( writer, "ok" );
            writer.close();
        }
    }
}
