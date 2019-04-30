//package utils;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.List;
//
//public class Util_Dao {
//	private static final Util_Dao dao = new Util_Dao();
//	private String dbname;
//	private Connection conn;
//
//	public Util_Dao setDbname(String dbname) {
//		this.dbname = dbname;
//		return this;
//	}
//
//	private Util_Dao() {
//
//	}
//
//	public static Util_Dao create() {
//		return dao;
//	}
//	/**
//	 * 建表和增加数据
//	 * @param object
//	 * @param sum
//	 * @return
//	 */
//	public int createTableandValue(Object object){
//		try {
//			createTable(object);
//			execute(Util_Sql.insertValueSqlSingle(object));
//			return 1;
//		} catch (Exception e) {
//			return 0;
//		}
//	}
//	/**
//	 * 获得带返回结果集的查找数据
//	 * @param sql
//	 * @return
//	 */
//	public ResultSet seach(String sql){
//		ResultSet res=null;
//		try {
//			conn = connect();
//			Statement stat = conn.createStatement();
//			res=stat.executeQuery(sql);
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
//		return res;
//	}
//	public int execute(List<String> sqllist){
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
////			System.out.println(sql);
//			for (int i = 0; i < sqllist.size(); i++) {
//				System.out.println(sqllist.get(i));
//				stat.execute(sqllist.get(i));
//			}
//
//			close();
//
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//	}
//	/**
//	 * 只是执行sql语句
//	 * @param sql
//	 * @return
//	 */
//	public int execute(String sql){
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
////			System.out.println(sql);
//			stat.execute(sql);
//			close();
//
//			return 1;
//		} catch (Exception e) {
//			System.out.println(sql);
//			e.printStackTrace();
//			return 0;
//		}
//	}
//	/**
//	 * 将list里的对象生成建表语句
//	 * @param list
//	 * @return
//	 */
//	public  int createTables(Util_List list){
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
//			for (int i = 0; i < list.size(); i++) {
//				String sql= Util_Sql.createTableSql(list.get(i));
//				System.out.println(sql);
//				stat.execute(sql);
////				String sql2=Util_ServerString.createViewSql(list.get(i));
////				System.out.println(sql2);
////				stat.execute(sql2);
//				System.out.println(Util_Sql.getClassLastName(list.get(i)));
//			}
//			close();
//			return 1;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return 0;
//		}
//
//	}
//	/**
//	 * 更新
//	 * @param upstring
//	 * @return
//	 */
//	public int update(String upstring){
//		int re=0;
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
//			re=stat.executeUpdate(upstring);
//			close();
//		} catch (Exception e) {
//		}
//		return re;
//	}
//	/**
//	 * 插入
//	 * @param upstring
//	 * @return
//	 */
//	public int insert(String upstring){
//		int re=0;
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
//			boolean ro=stat.execute(upstring);
//			if(ro){
//				re=1;
//			}
//			close();
//		} catch (Exception e) {
//		}
//		return re;
//	}
//	/**
//	 * 单一建表语句
//	 * @param object
//	 * @return
//	 */
//	public  int createTable(Object object){
//		try {
//			conn=connect();
//			Statement stat = conn.createStatement();
//			String sql= Util_Sql.createTableSql(object);
//			stat.execute(sql);
//			close();
//			return 1;
//		} catch (Exception e) {
//			return 0;
//		}
//
//	}
//	/**
//	 * 连接
//	 * @return
//	 */
//	private Connection connect() {
//		try {
//			String sqldb = "jdbc:sqlite://"+System.getProperty("user.dir")+"/SqlDb/"+dbname+"";
//			System.out.println(sqldb);
//			Class.forName("org.sqlite.JDBC");
//			Connection conn = DriverManager.getConnection(sqldb);
//			return conn;
//		} catch (Exception e) {
//			return null;
//		}
//	}
//
//	/**
//	 * 关闭
//	 * @return
//	 */
//	public int close() {
//		try {
//			conn.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return 0;
//	}
//	public static boolean isIdExsist(String tablename,String id){
//		boolean exsist=false;
//		try {
//			String seachsql="select * from "+tablename+" where id = \""+id+"\"";
//			ResultSet res= Util_Dao.create().setDbname("anjian.db").seach(seachsql);
//			if(res!=null){
//				while(res.next()){
//					exsist=true;
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return exsist;
//	}
//}
