package kr.ac.sungkyul.bookmall.dao.test;

import java.util.List;

import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookDaoTest {
	
	public static void main(String[] args) {

		testBookDaoInsert();
		testBookDaoGetList();
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
		BookDao dao = new BookDao();
		
		vo.setTitle("트와일라잇");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(1L);		
		dao.insert(vo);
		
		vo.setTitle("뉴문");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(1L);		
		dao.insert(vo);
		
		vo.setTitle("이클립스");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(1L);		
		dao.insert(vo);
		
		vo.setTitle("브레이킹던");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(1L);		
		dao.insert(vo);
		
		vo.setTitle("아리랑");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(2L);		
		dao.insert(vo);
		
		vo.setTitle("젊은그대");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(3L);		
		dao.insert(vo);
		
		vo.setTitle("아프니까 청춘이다");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(4L);		
		dao.insert(vo);
		
		vo.setTitle("귀천");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(5L);		
		dao.insert(vo);
		
		vo.setTitle("태백산맥");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(2L);		
		dao.insert(vo);
		
		vo.setTitle("풀하우스");
		vo.setRate(1);
		vo.setStatus(0);	// 0:재고있음, 1:대여중
		vo.setAuthorNo(6L);		
		dao.insert(vo);
	}
	
	
	
}
