package com.hbxy.ssm.util;

/*
    随机id生成，使用雪花算法

 */

/**
 * 雪花算法不依赖于数据库本身，是分布式id生成算法中比较经典的一种。
 * 整个ID的构成大概分为这么几个部分，时间戳差值，机器编码，进程编码，序列号。
 * java的long是64位的从左向右依次介绍是：时间戳差值，在我们这里占了42位；机器编码5位；进程编码5位；序列号12位。所有的拼接用位运算拼接起来，于是就基本做到了每个进程中不会重复了。
 *
 */
public class IdUtil {

    private static SnowFlake snowFlake;
//id自增器（雪花算法）
    public static Long nextId(){
       if(snowFlake == null){
           snowFlake= new SnowFlake(1,1);
       }
       return snowFlake.nextId();
    }
}
