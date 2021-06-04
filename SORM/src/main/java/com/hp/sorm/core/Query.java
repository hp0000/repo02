package com.hp.sorm.core;

import com.hp.sorm.bean.ColumInfo;
import com.hp.sorm.bean.TableInfo;
import com.hp.sorm.utils.JDBCUtils;
import com.hp.sorm.utils.ReflectUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责查询（对外提供服务的核心类）
 * @author huangpan
 */
public abstract class Query implements Cloneable, Serializable {

    /**
     * 采用模版方法模式将jdbc操作对象封装成模版，便于重用
     * @param sql
     * @param params
     * @param clazz
     * @param callBack
     * @return
     */
    public Object executeQueryTemplate(String sql,Object[] params,Class clazz,CallBack callBack){
        Connection conn = DBManager.getConn();
        List list=null;//封装查询记录
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=conn.prepareStatement(sql);
            //给sql传参
            JDBCUtils.handleParams(ps,params);
            System.out.println(ps);
            rs=ps.executeQuery();
            return callBack.doExecute(conn,ps,rs);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            DBManager.close(ps,conn);
        }
    }


    /**
     * 直接执行一个DML语句
     * @param sql
     * @param params
     * @return
     */
    public int executeDML(String sql,Object[] params) {
        int count=0;
        Connection conn = DBManager.getConn();
        PreparedStatement ps=null;
        try {
            ps=conn.prepareStatement(sql);
            JDBCUtils.handleParams(ps,params);
            count=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBManager.close(ps,conn);
        }
        return count;
    }

    /**
     * 将一个对象存储到数据库中
     * @param obj
     */
    public void insert(Object obj){
        Class c=obj.getClass();
        TableInfo tableInfo=TableContext.poClassTableMap.get(c);
        StringBuilder sql=new StringBuilder("insert into "+tableInfo.getTname()+"(");
        int countNotNullField=0;//计算不为空的属性值
        List<Object> params=new ArrayList<>();
        //目前只能处理数据库来维护自增主键的方式
        Field[] fields = c.getDeclaredFields();
        for (Field f:fields){
            String name = f.getName();
            Object fieldValue= ReflectUtils.invokeGet(name,obj);
            if (fieldValue!=null){
                countNotNullField++;
                sql.append(name+",");
                params.add(fieldValue);
            }
        }
        sql.setCharAt(sql.length()-1,')');
        sql.append(" values(");
        for (int i=0;i<countNotNullField;i++){
            sql.append("?,");
        }
        sql.setCharAt(sql.length()-1,')');
        System.out.println(sql.toString());
        executeDML(sql.toString(),params.toArray());
    }

    /**
     * 删除数据
     * @param clazz(表示类对应表中的记录)
     * @param id 主键的值
     * @return
     */
    public void delete(Class clazz,Object id){
        //通过Class对象找TableInfo
        TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
        ColumInfo onlyPrikey = tableInfo.getOnlyPrikey();

        String sql="delete from "+tableInfo.getTname()+" where "+onlyPrikey.getName()+"=? ";
        executeDML(sql,new Object[]{id});
    }

    /**
     * 删除对象在数据库中对应的记录
     * @param obj
     * @return
     */
    public void delete(Object obj){
        Class c=obj.getClass();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumInfo onlyPrikey = tableInfo.getOnlyPrikey(); //主键

        //通过反射机制调用属性对应的get方法或set方法

        Object prikeyValue = ReflectUtils.invokeGet(onlyPrikey.getName(), obj);
        delete(c,prikeyValue);
    }

    /**
     * 更新对像对应的记录，并且只更新制定的字段值
     * @param obj
     * @param fieldNames
     * @return
     */
    public int update(Object obj,String[] fieldNames){
        Class<?> c = obj.getClass();
        List<Object> params=new ArrayList<>();
        TableInfo tableInfo = TableContext.poClassTableMap.get(c);
        ColumInfo priKey=tableInfo.getOnlyPrikey();
        StringBuilder sql=new StringBuilder("update "+tableInfo.getTname()+" set ");

        for (String fname:fieldNames){
            Object fvalue = ReflectUtils.invokeGet(fname, obj);
            params.add(fvalue);
            sql.append(fname+"=?,");
        }
        sql.setCharAt(sql.length()-1,' ');
        sql.append(" where ");
        sql.append(priKey.getName()+"=?");
        params.add(ReflectUtils.invokeGet(priKey.getName(),obj));
        return executeDML(sql.toString(),params.toArray());
    }

    /**
     * 查询返回多行记录，并将每行记录封装到clazz指定的对象中
     * @param sql
     * @param clazz 封装数据的javabean类的class对象
     * @param params
     * @return
     */
    public List<Object> queryRows(final String sql,final Class clazz,final Object[] params){
        return (List)executeQueryTemplate(sql, params, clazz, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                List list=null;
                try {

                    ResultSetMetaData metaData = rs.getMetaData();
                    while (rs.next()){
                        if (list==null){
                            list=new ArrayList();
                        }
                        Object rowObj = clazz.newInstance();//相当于javabean的无参构造器
                        //多列 select username,pwd,age from user where id>? and age>18
                        for (int i=0;i<metaData.getColumnCount();i++){
                            String columnName=metaData.getColumnLabel(i+1);
                            Object columnValue=rs.getObject(i+1);

                            //调用rowObj的setUsername方法，将columnValue的值设置进去
                            ReflectUtils.invokeSet(rowObj,columnName,columnValue);
                        }
                        list.add(rowObj);
                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return list;
            }
        });
    }

    /**
     * 查询返回一行记录
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object queryUniqueRow(String sql, Class clazz, Object[] params){
        List list=queryRows(sql,clazz,params);
        return (list==null&&list.size()>0)?null:list.get(0);
    }

    /**
     * 查询返回一个值
     * @param sql
     * @param params
     * @return
     */
    public Object queryValue(String sql,Object[] params){
        return executeQueryTemplate(sql, params, null, new CallBack() {
            @Override
            public Object doExecute(Connection conn, PreparedStatement ps, ResultSet rs) {
                Object value=null;
                try{
                    while(rs.next()) {
                        value=rs.getObject(1);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
                return value;
            }
        });
    }

    /**
     * 查询返回一个数值
     * @param sql
     * @param params
     * @return
     */
    public Number queryNumber(String sql,Object[] params){
        return (Number) queryValue(sql,params);
    }

    /**
     * 分页查询
     * @param pageNum
     * @param size
     * @return
     */
    public abstract Object queryPagenate(int pageNum,int size);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
