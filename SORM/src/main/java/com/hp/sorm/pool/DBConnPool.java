package com.hp.sorm.pool;

import com.hp.sorm.core.DBManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 连接池的类
 * @author huangpan
 */
public class DBConnPool {
    /**
     * 连接池对象
     */
    private  List<Connection> pool;

    /**
     * 最大连接数
     */
    private static final int POOL_MAX_SIZE=DBManager.getConf().getPoolMaxSize();

    /**
     * 最小连接数
     */
    private static final int POOL_MIN_SIZE=DBManager.getConf().getPoolMinSize();


    public void initPool(){
        if (pool==null){
            pool=new ArrayList<Connection>();
        }
        while(pool.size()<DBConnPool.POOL_MIN_SIZE){
            pool.add(DBManager.createConn());
            System.out.println("初始化连接池，池中的连接数达到最小值"+pool.size());
        }
    }

    /**
     * 从连接池中取出一个连接
     * @return
     */
    public synchronized Connection getConnection(){
        int last_index=pool.size()-1;
        Connection connection = pool.get(last_index);
        pool.remove(last_index);
        return connection;
    }

    /**
     * 将连接放回池中
     * @param conn
     */
    public synchronized void close(Connection conn) {
        if (pool.size()>=POOL_MAX_SIZE){
            try {
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            pool.add(conn);
        }
    }


    public DBConnPool(){
        initPool();
    }
}
