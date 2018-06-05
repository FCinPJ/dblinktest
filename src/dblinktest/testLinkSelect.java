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
	            sql = "SELECT * FROM producttype;";//sql���
	            ResultSet rs = stmt.executeQuery(sql);
	            // ��ɺ�ر�
	            List list = new ArrayList();
	            ResultSetMetaData md = rs.getMetaData();//��ȡ����
	            int columnCount = md.getColumnCount();//��ȡ�е�����
	            while (rs.next()) {
	            Map rowData = new HashMap();//����Map
	            for (int i = 1; i <= columnCount; i++) {
	            rowData.put(md.getColumnName(i), rs.getObject(i));//��ȡ������ֵ
	            }
	            list.add(rowData);
	            }
	            System.out.println(list);
	            
	            rs.close();
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
