package com.example.springboot.util;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName StringUtils.java
 * @Description 字符串工具类
 * @createTime 2021年12月28日 11:12:00
 */

public class StringUtils {
    public static boolean isEmpty(String str) {
        int strLenth;
        if (null == str || (strLenth = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLenth; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
