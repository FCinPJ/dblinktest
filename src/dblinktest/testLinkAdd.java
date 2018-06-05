package dblinktest;

import static org.junit.Assert.*;

import java.sql.*;

import org.junit.Test;

public class testLinkAdd {
	@Test
	public void testAdd() {
		
		// JDBC �����������ݿ� URL
	    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://localhost:3306/test1";
	 
	    // ���ݿ���û���������
	    final String USER = "root";
	    final String PASS = "123456";
	 
	        Connection conn = null;
	        Statement stmt = null;
	        try{
	            // ע�� JDBC ����
	            Class.forName(JDBC_DRIVER);
	        
	            // ������
	            System.out.println("�������ݿ�...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	            // ִ�в�ѯ
	            System.out.println(" ʵ����Statement����...");
	            stmt = conn.createStatement();
	            String sql;
	            sql = "INSERT INTO producttype(typeID,typeName) VALUE(1,'��װ��');";//sql���
	            stmt.executeUpdate(sql);
	            sql = "INSERT INTO producttype(typeID,typeName) VALUE(2,'����ʳ��');";//sql���
	            stmt.executeUpdate(sql);
	            sql = "INSERT INTO producttype(typeID,typeName) VALUE(1,'��װŮ');";//sql���
	            stmt.executeUpdate(sql);
	            sql = "INSERT INTO producttype(typeID,typeName) VALUE(2,'���ʳ��');";//sql���
	            stmt.executeUpdate(sql);
	            sql = "INSERT INTO producttype(typeID,typeName) VALUE(4,'����');";//sql���
	            stmt.executeUpdate(sql);
	            // ��ɺ�ر�
	            
	            stmt.close();
	            conn.close();
	        }catch(SQLException se){
	            // ���� JDBC ����
	            se.printStackTrace();
	        }catch(Exception e){
	            // ���� Class.forName ����
	            e.printStackTrace();
	        }finally{
	            // �ر���Դ
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// ʲô������
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	        System.out.println("Goodbye!");
	    }
	
}