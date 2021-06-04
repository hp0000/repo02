package com.hp.sorm.bean;

/**
 * 封装表中一个字段的信息
 * @author huangpan
 */
public class ColumInfo {
    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段的数据类型
     */
    private String dataType;

    /**
     * 键的类型(0:普通键 1：主键 2：外键
     */
    private int keyType;

    public ColumInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }

    public ColumInfo(String name, String dataType, int keyType) {
        this.name = name;
        this.dataType = dataType;
        this.keyType = keyType;
    }
}
