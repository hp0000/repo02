package com.hp.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表结构的信息
 * @author huangpan
 */
public class TableInfo {
    /**
     * 表名
     */
    private String tname;

    /**
     * 所有字段信息
     */
    private Map<String,ColumInfo> columns;

    /**
     * 唯一主键
     */
    private ColumInfo onlyPrikey;

    /**
     * 存储联合主键
     */
    private List<ColumInfo> getPrikeys;

    public TableInfo(String tname, Map<String, ColumInfo> columns, List<ColumInfo> getPrikeys) {
        this.tname = tname;
        this.columns = columns;
        this.onlyPrikey = onlyPrikey;
        this.getPrikeys = getPrikeys;
    }

    public TableInfo() {
    }

    public List<ColumInfo> getPrikeys() {
        return getPrikeys;
    }

    public void setPrikeys(List<ColumInfo> getPrikeys) {
        this.getPrikeys = getPrikeys;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Map<String, ColumInfo> getColumns() {
        return columns;
    }

    public void setColumns(Map<String, ColumInfo> columns) {
        this.columns = columns;
    }

    public ColumInfo getOnlyPrikey() {
        return onlyPrikey;
    }

    public void setOnlyPrikey(ColumInfo onlyPrikey) {
        this.onlyPrikey = onlyPrikey;
    }
}
