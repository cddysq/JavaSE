package com.javase.study.reflex;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @Author：Haotian
 * @Date：2019/10/13 15:55
 * 通过反射加载配置文件执行方法，提高灵活性
 */
public class LoadConfig {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties pro = new Properties();
        //加载配置文件路径
        FileReader config = new FileReader( "resources/config" );
        //读取配置文件
        pro.load( config );
        config.close();
        //通过键 获取值
        String className = pro.getProperty( "className" );
        String methodName = pro.getProperty( "methodName" );

        //通过反射加载读取到的路径得到字节码文件
        Class<?> aClass = Class.forName( className );
        //获取构造函数
        Constructor<?> constructor = aClass.getConstructor();
        //创建新对象
        Object o = constructor.newInstance();
        //获取字节码中需要的方法
        Method method = aClass.getMethod( methodName );
        //执行方法
        method.invoke( o );
    }
}
