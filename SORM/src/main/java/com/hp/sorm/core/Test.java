package com.hp.sorm.core;

import com.hp.po.Actor;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        QueryFactory factory = QueryFactory.getInstance();
        Query query = factory.createQuery();
        List<Object> objects = query.queryRows("select * from actor where actor_id=?", Actor.class, new Object[]{180});
        for (Object obj:objects){
            System.out.println(((Actor)obj).toString());
        }
    }
}
