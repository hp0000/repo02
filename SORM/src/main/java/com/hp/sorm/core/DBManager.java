package com.hp.sorm.core;

import com.hp.sorm.bean.Configuration;
import com.hp.sorm.pool.DBConnPool;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息维持对象的管理(增加连接池功能)
 * @author huangpan
 */
public class DBManager {
    /**
     * 配置信息的类
     */
    private static Configuration conf;
    /**
     * 数据库连接池对象
     */
    private static DBConnPool pool;

    static {
        Properties pros=new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf=new Configuration();
        conf.setDriver(pros.getProperty("mysqlDriver"));
        conf.setUrl(pros.getProperty("mysqlURL"));
        conf.setUser(pros.getProperty("mysqlUser"));
        conf.setPwd(pros.getProperty("mysqlPwd"));
        conf.setSrcPath(pros.getProperty("srcPath"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setQueryClass(pros.getProperty("queryClass"));
        conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
        conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
        //加载TableContext
        System.out.println(TableContext.class);
    }

    /**
     * 获取数据库连接对象
     * @return
     */
    public static Connection getConn(){
        if (pool==null){
            pool=new DBConnPool();
        }
        return pool.getConnection();
    }

    /**
     * 获取新的连接对象
     * @return
     */
    public static Connection createConn(){
        Connection conn=null;
        try {
            Class.forName(conf.getDriver());
            conn=DriverManager.getConnection(conf.getUrl(),conf.getUser(),conf.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }

    /**
     * 关闭相关数据库连接资源
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs, Statement ps,Connection conn){
        try{
            if (rs!=null){
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if (ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        pool.close(conn);

    }

    /**
     * 关闭数据库连接池的相关连接
     * @param ps
     * @param conn
     */
    public static void close(Statement ps,Connection conn){
        try{
            if (ps!=null){
                ps.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        pool.close(conn);

    }

    /**
     * 获取配置文件类信息
     * @return
     */
    public static Configuration getConf(){
        return conf;
    }

}
