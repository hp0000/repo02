package com.hp.sorm.core;

import com.hp.sorm.bean.ColumInfo;
import com.hp.sorm.bean.TableInfo;
import com.hp.sorm.utils.JavaFileUtils;
import com.hp.sorm.utils.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 负责获取管理数据库所有表结构和类结构的关系，并可以根据表结构生成类结构
 * @author huangpan
 */
public class TableContext {
    /**
     * 表名为key，表信息对象为value
     */
    public static Map<String, TableInfo> tables = new HashMap<String,TableInfo>();

    /**
     * 将po的class对象和表信息对象关联起来，便于重用！
     */
    public static  Map<Class,TableInfo>  poClassTableMap = new HashMap<Class,TableInfo>();


    private TableContext(){}

    static {
        try {
            //初始化获得表的信息
            Connection con = DBManager.getConn();
            DatabaseMetaData dbmd = con.getMetaData();

            ResultSet tableRet = dbmd.getTables(null, "%","%",new String[]{"TABLE"});

            while(tableRet.next()){
                String tableName = (String) tableRet.getObject("TABLE_NAME");

                TableInfo ti = new TableInfo(tableName,new HashMap<String, ColumInfo>(),new ArrayList<ColumInfo>());
                tables.put(tableName, ti);

                ResultSet set = dbmd.getColumns(null, "%", tableName, "%");  //查询表中的所有字段
                while(set.next()){
                    ColumInfo ci = new ColumInfo(set.getString("COLUMN_NAME"),
                            set.getString("TYPE_NAME"), 0);
                    ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
                }

                ResultSet set2 = dbmd.getPrimaryKeys(null, "%", tableName);  //查询t_user表中的主键
                while(set2.next()){
                    ColumInfo ci2 = (ColumInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
                    ci2.setKeyType(1);  //设置为主键类型
                    ti.getPrikeys().add(ci2);
                }

                if(ti.getPrikeys().size()>0){  //取唯一主键。。方便使用。如果是联合主键。则为空！
                    ti.setOnlyPrikey(ti.getPrikeys().get(0));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //更新类结构
        updateJavaPOFile();

        loadPOTables();

    }

    /**
     * 根据表结构，更新配置的po包下的java类
     * 实现了从表结构转化到类结构
     */
    public static void updateJavaPOFile(){
        for(TableInfo t:tables.values()){
            JavaFileUtils.createJavaPOFile(t,new MysqlTypeConvertor());
        }


    }

    /**
     * 加载po包下面的类
     */
    public static void loadPOTables() {
        for (TableInfo tableInfo:tables.values()){
            try {
                Class c = Class.forName(DBManager.getConf().getPoPackage()+"."+ StringUtils.firstChar2UpperCase(tableInfo.getTname()));
                poClassTableMap.put(c,tableInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Map<String, TableInfo> getTables() {
        return tables;
    }

    public static void main(String[] args) throws SQLException {
//        tables.clear();
        Map<String,TableInfo>  tables = TableContext.tables;

        System.out.println(TableContext.tables.size());
        System.out.println(tables.size());
        System.out.println(poClassTableMap.size());
    }

}
