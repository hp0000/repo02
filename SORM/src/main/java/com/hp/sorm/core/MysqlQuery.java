package com.hp.sorm.core;


import com.hp.po.Actor;

import java.util.List;

/**
 * 负责对mysql数据库的查询
 * @author huangpan
 */
public class MysqlQuery extends Query{

    @Override
    public Object queryPagenate(int pageNum, int size) {
        return null;
    }

    public static void main(String[] args) {
        List<Object> list = new MysqlQuery().queryRows("select * from actor where actor_id=?", Actor.class, new Object[]{180});
        System.out.println(list.size());
        for (Object obj:list){
            System.out.println(((Actor)obj).toString());
        }
    }
}
