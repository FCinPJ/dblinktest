package dblinktest;

import static org.junit.Assert.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class testLinkSelect {
	
	@Test
	public void testSelect() {
		
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
	            sql = "SELECT * FROM producttype;";//sql语句
	            ResultSet rs = stmt.executeQuery(sql);
	            // 完成后关闭
	            List list = new ArrayList();
	            ResultSetMetaData md = rs.getMetaData();//获取键名
	            int columnCount = md.getColumnCount();//获取行的数量
	            while (rs.next()) {
	            Map rowData = new HashMap();//声明Map
	            for (int i = 1; i <= columnCount; i++) {
	            rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
	            }
	            list.add(rowData);
	            }
	            System.out.println(list);
	            
	            rs.close();
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
