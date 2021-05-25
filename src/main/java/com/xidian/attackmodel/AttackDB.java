package com.xidian.attackmodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: quan
 * @Date: 2021/05/21/14:57
 * @Description:
 */
public class AttackDB {

    // MySQL 8.0 以下版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/attack_model";

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "mysql";
    static Connection conn;
    private AttackDB(){}
    private static AttackDB attackDB;

    public static AttackDB getInstance() {
        if (attackDB == null) {
            synchronized (AttackDB.class) {
                if (attackDB == null) {
                    attackDB = new AttackDB();
                    getConn();
                }
            }
        }
        return attackDB;
    }
    public static Connection getConn() {
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            // 打开链接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //获得所有的type
    public List<AttackType> getAllType() {
        List<AttackType> attackTypeList = new ArrayList<>();
        String sql = "select * from attack_type";
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            int id;
            String type;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                type = resultSet.getString("name");
                attackTypeList.add(new AttackType(id,type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attackTypeList;
    }

    //获得所有的type
    public List<AttackPhase> getAllPhase() {
        List<AttackPhase> attackPhaseList = new ArrayList<>();
        String sql = "select * from attack_phase";
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            int id;
            String name;
            while (resultSet.next()) {
                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                attackPhaseList.add(new AttackPhase(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attackPhaseList;
    }
    //通过type id 和 phase id 获得 attack
    public List<AttackVO> getAttackByTypeAndAttack(String typeId,String methodId){
        List<AttackVO> attackList = new ArrayList<>();
        String sql = "";
        if (typeId.equals("") && methodId.equals("")) {
            return null;
        }
        else if ("".equals(methodId)) {
            sql = "select * from attack where type_id = " + typeId;
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p " +
                    "where type_id ="+typeId+" and t.id = type_id and p.id = method_id";
        } else if ("".equals(typeId)) {
            sql = "select * from attack where method_id = " + methodId;
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p " +
                    "where method_id ="+methodId+" and t.id = type_id and p.id = method_id";
        }else{
            sql = "select * from attack where type_id =" + typeId + " and method_id = " + methodId;
            sql = "select a.id,a.name,t.name,p.name \n" +
                    "from attack a,attack_type t,attack_phase p \n" +
                    "where type_id="+typeId+" and method_id ="+methodId+" and t.id = type_id and p.id = method_id;";
        }
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            int id;
            String name;
            String typeName;
            String methodName;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                name = resultSet.getString(2);
                typeName = resultSet.getString(3);
                methodName = resultSet.getString(4);
                attackList.add(new AttackVO(id,name,typeName,methodName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attackList;
    }

    public List<AttackVO> getData(int id) {
        String sql = "select data_method,out_band_id,in_band_id,name from attack where id = "+id;
        List<AttackVO> attackVOS = new ArrayList<>();
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            String sql1;
            ResultSet resultSet1;
            ResultSet resultSet2;
            String dataMethod;
            String inBand;
            String outBand;
            String name;
            while (resultSet.next()) {
                dataMethod = resultSet.getString(1);
                inBand = resultSet.getString(2);
                name = resultSet.getString(4);
                StringBuilder inBandString = new StringBuilder();
                StringBuilder outBandString = new StringBuilder();
                if (inBand != null && !"".equals(inBand)) {
                    sql1 = "select name from datas where id in ("+inBand+")";
                    Statement statement1 = conn.createStatement();
                    resultSet1 = statement1.executeQuery(sql1);

                    while (resultSet1.next()) {
                        inBandString.append(resultSet1.getString(1)).append(";");
                    }
                }
                outBand = resultSet.getString(3);
                if (outBand != null && !"".equals(outBand)) {
                    sql1 = "select name from datas where id in ("+outBand+")";
                    Statement statement2 = conn.createStatement();
                    resultSet2 = statement2.executeQuery(sql1);
                    while (resultSet2.next()) {
                        outBandString.append(resultSet2.getString(1)).append(";");
                    }
                }
                attackVOS.add(new AttackVO(id,name,dataMethod,inBandString.toString(),outBandString.toString()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attackVOS;
    }

    public List<KeyWordVO> getKeyWord(String key) {
        List<KeyWordVO> keyWordVOList = new ArrayList<>();
        String sql = "SELECT keyword,type FROM keyword where keyword like '%"+key+"%'";
        Statement statement;
        ResultSet resultSet;
        int count = 0;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            String keyword;
            int type;
            while (resultSet.next()) {
                if (count > 30) {
                    return keyWordVOList;
                }
                keyword = resultSet.getString(1);
                type = resultSet.getInt(2);
                keyWordVOList.add(new KeyWordVO(keyword,type));
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return keyWordVOList;
    }

    public List<AttackVO> getAttackByKeyword(String keyword, int type) {
        List<AttackVO> attackVOS = new ArrayList<>();
        String sql = "";
        if (type == 1) {
            //代表攻击类型
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p" +
                    " where t.id =a.type_id and p.id = a.method_id and t.name = '"+ keyword+"'";
        } else if (type == 2) {
            //代表攻击方式
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p" +
                    " where t.id =a.type_id and p.id = a.method_id and p.name = '"+ keyword+"'";
        } else if (type == 3) {
            //代表直接搜攻击
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p" +
                    " where t.id =a.type_id and p.id = a.method_id and a.name = '"+ keyword+"'";
        }else{
            return null;
        }
        Statement statement;
        ResultSet resultSet;
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            int id;
            String name;
            String typeName;
            String methodName;
            while (resultSet.next()) {
                id = resultSet.getInt(1);
                name = resultSet.getString(2);
                typeName = resultSet.getString(3);
                methodName = resultSet.getString(4);
                attackVOS.add(new AttackVO(id,name,typeName,methodName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attackVOS;
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * from attack";
            sql = "select a.id,a.name,t.name,p.name from attack a,attack_type t,attack_phase p " +
                    "where type_id ="+1+" and t.id = type_id and p.id = method_id";
            sql = "select data_method,out_band_id,in_band_id from attack where id = "+1;
            ResultSet resultSet = stmt.executeQuery(sql);

            String sql1;
            ResultSet resultSet1;
            String dataMethod;
            String inBand;
            String outBand;
            while (resultSet.next()) {
                dataMethod = resultSet.getString(1);
                inBand = resultSet.getString(2);
                sql1 = "select name from datas where id in ("+inBand+")";
                Statement stmt1 = conn.createStatement();
                resultSet1 = stmt1.executeQuery(sql1);
                StringBuilder inBandString = new StringBuilder();
                while (resultSet1.next()) {
                    inBandString.append(resultSet1.getString(1)).append(";");
                }
                System.out.println(inBandString.toString());
                outBand = resultSet.getString(3);
            }
            // 完成后关闭
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }// 什么都不做
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}