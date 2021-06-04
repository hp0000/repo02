package com.hp.sorm.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装jdbc查询的常用操作
 * @author huangpan
 */
public class JDBCUtils {

    /**
     * 给sql传参数
     * @param ps
     * @param params
     */
    public static void handleParams(PreparedStatement ps,Object[] params){

        if (params!=null){
            for (int i=0;i<params.length;i++){
                try {
                    ps.setObject(1+i,params[i]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
