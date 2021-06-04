package com.hp.sorm.core;

/**
 * mysql数据类型和java数据类型的转换
 * @author huangpan
 */
public class MysqlTypeConvertor implements TypeConvertor{
    public String databaseType2JavaType(String columnType) {
        if ("text".equals(columnType)||"set".equals(columnType)||"varchar".equals(columnType)||"char".equals(columnType)||"geometry".equals(columnType)){
            return "String";
        }else if ("bigint".equals(columnType)){
            return "Long";
        }else if ("double".equals(columnType)||"float".equals(columnType)){
            return "Double";
        }else if ("clob".equals(columnType)){
            return "java.sql.Clob";
        }else if ("blob".equals(columnType)){
            return "java.sql.Blob";
        }else if ("time".equals(columnType)){
            return "java.sql.Time";
        }else if ("timestamp".equals(columnType)||"datetime".equals(columnType)){
            return "java.sql.Timestamp";
        }else if ("date".equals(columnType)||"year".equals(columnType)){
            return "java.sql.Date";
        }else if (columnType.toLowerCase().contains("int")||columnType.toLowerCase().contains("smallint")){
            return "Integer";
        }else if ("decimal".equals(columnType)){
            return "java.math.BigDecimal";
        }else if ("enum".equals(columnType)){
            return "java.lang.Enum";
        }else if ("tinyint unsigned".equals(columnType)||"tinyint".equals(columnType)){
            return "Integer";
        }
        return null;
    }

    public String javaType2DatabaseType(String javaDataType) {
        return null;
    }
}
