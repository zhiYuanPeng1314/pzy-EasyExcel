package com.pzy.utils;

public class TestFileUtils {
    //获取磁盘路径
    public static String getPath(){
        return TestFileUtils.class.getResource("/").getPath().replace("classes/","");
    }

    public static void main(String[] args) {
        System.out.println(getPath());
    }
}
