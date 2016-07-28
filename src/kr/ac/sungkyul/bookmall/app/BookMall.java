package kr.ac.sungkyul.bookmall.app;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.AuthorDao;
import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.AuthorVo;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookMall {
	
	public static void main(String[] args) {
		testBookDaoInsert();
		testBookDaoGetList();
//		testAuthorDaoInsert();
//		testAuthorDaoGetList();
	}
	
	public static void testBookDaoGetList() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void testBookDaoInsert() {
		BookVo vo = new BookVo();
		vo.setTitle("해커스토익");
		vo.setRate(5);
		
		BookDao dao = new BookDao();
		dao.insert(vo);
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
		vo.setName("플라톤");
		vo.setDescription(null);
		
		AuthorDao dao = new AuthorDao();
		dao.insert(vo);
		
	}

}
