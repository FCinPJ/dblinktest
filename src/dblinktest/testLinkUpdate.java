package dblinktest;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.Test;

public class testLinkUpdate {
	@Test
	public void testUpdate() {
		
		// JDBC 驱动名及数据库 URL
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:3306/test1";
	 
	    // 数据库的用户名与密码
	    final String USER = "root";
	    final String PASS = "123456";
	 
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName(JDBC_DRIVER);
	        
	            // 打开链接
	            System.out.println("连接数据库...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            // 执行查询
	            System.out.println(" 实例化Statement对象...");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "UPDATE producttype SET typeID=3,typeName='手机' WHERE typeID=4;";//sql语句
	            stmt.executeUpdate(sql);
	            // 完成后关闭
	            
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Goodbye!");
	    }
	
}
