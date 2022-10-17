package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HMMDao {
    private static final HMMDao instance=new HMMDao();
    public static HMMDao getInstance(){
        return instance;
    }
    private Connection conn;

    public HMMDao setDbname(String dbname) {
        instance.dbname = dbname;
        return instance;
    }

    private String dbname;
    public int close() {
        try {
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return 0;
    }
    /**
     * 连接
     * @return
     */
    private Connection connect() {
        if(conn!=null){
            return conn;
        }
        try {
            String sqldb = "jdbc:sqlite://D:/Work/hmmcopy"+"";
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(sqldb);
            return conn;
        } catch (Exception e) {
            System.out.println("数据库链接失败");
            return null;
        }
    }
    public int add(String sql){
        try {
            conn=connect();
            Statement stat = conn.createStatement();
			System.out.println(sql);
            stat.execute(sql);
//            close();
            System.out.println("插入成功");
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int delete(String sql){
        try {
            conn=connect();
            Statement stat = conn.createStatement();
//			System.out.println(sql);
            stat.execute(sql);
//            close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int update(String sql){
        try {
            conn=connect();
            Statement stat = conn.createStatement();
//			System.out.println(sql);
            stat.execute(sql);
//            close();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ResultSet select(String sql){
        ResultSet res=null;
        try {
            conn = connect();
            Statement stat = conn.createStatement();
            res=stat.executeQuery(sql);
        } catch (Exception e) {
            System.out.println("当前错误Sql:"+sql);
            e.printStackTrace();

        }
        return res;
    }
    public int createTable(String sql){
        try {
            conn=connect();
            Statement stat = conn.createStatement();
            stat.execute(sql);
//            close();
            System.out.println("创建表成功");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
