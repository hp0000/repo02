package com.hp.sorm.core;

/**
 * 负责根据配置信息创建对应的query对象
 * @author huangpan
 */
public class QueryFactory {
    private QueryFactory(){};
    private static QueryFactory factory=new QueryFactory();
    private static Query protoTypeObj;//原型模式
    static{
        try {
            Class c = Class.forName(DBManager.getConf().getQueryClass());
            protoTypeObj=(Query) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 克隆模式创建Query对象
     * @return
     */
    public Query createQuery(){
        try {
            return (Query) protoTypeObj.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得QueryFactory对象
     * @return
     */
    public static QueryFactory getInstance(){
        return factory;
    }

}
