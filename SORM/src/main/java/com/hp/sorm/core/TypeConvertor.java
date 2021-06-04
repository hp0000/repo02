package com.hp.sorm.core;

/**
 * 负责java数据类型和数据库类型的互相转换
 * @author huangpan
 */
public interface TypeConvertor {

    /**
     * 将数据库类型转换成相应的java的数据类型
     * @param columnType 数据库字段的数据类型
     * @return java的数据类型
     */
    public String databaseType2JavaType(String columnType);

    /**
     * 激昂java类型转换成数据库的数据类型
     * @param javaDataType java数据类型
     * @return 数据库类型
     */
    public String javaType2DatabaseType(String javaDataType);
}
