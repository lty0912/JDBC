package kr.ac.sungkyul.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.hr.vo.EmployeeVo;

public class EmployeeDao {

	public List<EmployeeVo> getList(String name) {
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			String sql = "SELECT first_name, last_name, "
					+ " email, phone_number, to_char(hire_date, 'yyyy-mm-dd')" 
					+ " FROM EMPLOYEES "
					+ "WHERE first_name LIKE ? " 
					+ "OR last_name LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%" + name + "%");
			pstmt.setString(2, "%" + name + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				String email = rs.getString(3);
				String phoneNumber = rs.getString(4);
				String hireDate = rs.getString(5);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setEmail(email);
				vo.setPhoneNumber(phoneNumber);
				vo.setHireDate(hireDate);
				
				list.add(vo);
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 로딩 할 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return list;
	}
	
	
	
	
	
	
	public List<EmployeeVo> getList(Integer minSalary, Integer maxSalary) {
		
		List<EmployeeVo> list = new ArrayList<EmployeeVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			String sql = "SELECT first_name, last_name, salary FROM EMPLOYEES WHERE ? < salary AND salary < ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, minSalary);
			pstmt.setInt(2, maxSalary);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				Integer salary = rs.getInt(3);				
				
				EmployeeVo vo = new EmployeeVo();
				vo.setFirstName(firstName);
				vo.setLastName(lastName);
				vo.setSalary(salary);
				
				list.add(vo);
			}
			

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 로딩 할 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return list;	
		
	
	}
	
	

}
