package kr.ac.sungkyul.bookmall.dao.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.ac.sungkyul.bookmall.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class AuthorDaoTest {

	public static void main(String[] args) {

		testAuthorDaoInsert();
		testAuthorDaoGetList();
	}
	
	public static void testAuthorDaoGetList() {
		AuthorDao dao = new AuthorDao();
		List<AuthorVo> list = dao.getList();
		
		for (AuthorVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void testAuthorDaoInsert() {
		AuthorVo vo = new AuthorVo();
		vo.setName("스테파니메이어");
		vo.setDescription(null);		
		AuthorDao dao = new AuthorDao();
		dao.insert(vo);
		
		vo.setName("조정래");
		vo.setDescription(null);		
		dao = new AuthorDao();
		dao.insert(vo);
		
		vo.setName("김동인");
		vo.setDescription(null);		
		dao = new AuthorDao();
		dao.insert(vo);
		
		vo.setName("김난도");
		vo.setDescription(null);		
		dao = new AuthorDao();
		dao.insert(vo);
		
		vo.setName("천상병");
		vo.setDescription(null);		
		dao = new AuthorDao();
		dao.insert(vo);
		
		vo.setName("원수연");
		vo.setDescription(null);		
		dao = new AuthorDao();
		dao.insert(vo);
		
		
	}
	
	
}
