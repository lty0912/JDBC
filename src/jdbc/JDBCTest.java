package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");

			// 3. statement 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "SELECT employee_id, first_name, last_name, salary FROM EMPLOYEES";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과처리
			while (rs.next()) {
				int employeeId = rs.getInt(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);
				int salary = rs.getInt(4);

				System.out.println(employeeId + ":" + firstName + ":" + lastName + ":" + salary);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 6. 자원정리
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
	}

}
