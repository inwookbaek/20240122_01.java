package com.lec.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

	final static String DRV = "com.mysql.cj.jdbc.Driver";
//	final static String DRV = "com.mysql.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/payroll";
	final static String USR = "root";
	final static String PWD = "12345";
	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from employees where employee_id = 100";
		
		try {
			Class.forName(DRV);
			conn = DriverManager.getConnection(URL, USR, PWD);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			int employee_id = rs.getInt(1);
			String first_name = rs.getString(2);
			String last_name = rs.getString("LAST_NAME");
			int salary = rs.getInt("salary");
			
			System.out.println(employee_id + ", " + first_name + "." + last_name + ", " + salary);
			
		} catch (Exception e) {
			System.out.println("DB연결실패!!!");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// dummy
			}
		}
	}

}