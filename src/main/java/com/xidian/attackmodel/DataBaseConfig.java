package com.xidian.attackmodel;

/**
 * @Author: quan
 * @Date: 2021/05/26/13:37
 * @Description:
 */
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 获取数据库连接池
 */
@ConfigurationProperties(prefix = "mysql")
public class DataBaseConfig {
    private static volatile AttackDB dataBase = null;
    private static String driver;
    public static String url;
    private static String user;
    private static String password;

    // 创建单例连接池对象
    public AttackDB getDataBase() {
        if (dataBase == null) {
            synchronized (DataBaseConfig.class) {
                if (dataBase == null) {
                    dataBase = new AttackDB(driver, url, user, password);
                }
            }
        }
        return dataBase;
    }

    private DataBaseConfig() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
