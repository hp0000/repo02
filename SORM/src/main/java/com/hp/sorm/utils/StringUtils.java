package com.hp.sorm.utils;

/**
 * 封装了字符串常用的操作
 * @author huangpan
 */
public class StringUtils {
    /**
     * 将目标字符串首字母大写
     * @param str
     * @return
     */
    public static String firstChar2UpperCase(String str){
        return str.toUpperCase().substring(0,1)+str.substring(1);
    }
}
