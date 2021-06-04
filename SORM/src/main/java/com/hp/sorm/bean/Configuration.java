package com.hp.sorm.bean;

/**
 * 管理配置信息
 * @author huangpan
 */
public class Configuration {
    /**
     * 驱动类
     */
    private String driver;
    /**
     * jdbcurl
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String user;
    /**
     * 数据库密码
     */
    private String pwd;
    /**
     * 项目源码路径
     */
    private String srcPath;
    /**
     * 扫描生成java类的包
     */
    private String poPackage;

    /**
     * 查询类的类型
     */
    private String queryClass;

    /**
     * 连接池中最小的连接数
     */
    private int poolMinSize;

    /**
     * 连接池中最大的连接数
     */
    private int poolMaxSize;

    public int getPoolMinSize() {
        return poolMinSize;
    }

    public void setPoolMinSize(int poolMinSize) {
        this.poolMinSize = poolMinSize;
    }

    public int getPoolMaxSize() {
        return poolMaxSize;
    }

    public void setPoolMaxSize(int poolMaxSize) {
        this.poolMaxSize = poolMaxSize;
    }

    public String getQueryClass() {
        return queryClass;
    }

    public void setQueryClass(String queryClass) {
        this.queryClass = queryClass;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(String srcPath) {
        this.srcPath = srcPath;
    }

    public String getPoPackage() {
        return poPackage;
    }

    public void setPoPackage(String poPackage) {
        this.poPackage = poPackage;
    }

    public Configuration() {
    }

    public Configuration(String driver, String url, String user, String pwd, String srcPath, String poPackage) {
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.srcPath = srcPath;
        this.poPackage = poPackage;
    }
}
