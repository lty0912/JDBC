package kr.ac.sungkyul.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDao {
	
	public List<BookVo> getList() {
		List<BookVo> list = new ArrayList<BookVo>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement 생성
			stmt = conn.createStatement();

			// 4. SQL문 실행
			String sql = "SELECT no, title, rate, author_no FROM BOOK ORDER BY no ASC";
			rs = stmt.executeQuery(sql);
			
			// 5. 결과처리
			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Integer rate = rs.getInt(3);
				Long authorNo = rs.getLong(4);

				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setRate(rate);
				vo.setAuthorNo(authorNo);
				
				list.add(vo);
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
		
		return list;
	}
	
	
	
	
	public int insert(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int count=0;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "skudb", "skudb");

			// 3. statement 준비
			String sql = "INSERT into book values(seq_book.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 4. 바인딩
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getRate());
			pstmt.setLong(3, 1);	// 일단 1로 맞춤
			
			// 5. query 실행			
			count = pstmt.executeUpdate();	//갯수를 반환			

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패" + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				System.out.println("error: " + e);
			}
		}
		return count;
	}
	
	
	
	
	
	
	
	

}
