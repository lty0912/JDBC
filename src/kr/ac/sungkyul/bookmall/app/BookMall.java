package kr.ac.sungkyul.bookmall.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.ac.sungkyul.bookmall.dao.BookDao;
import kr.ac.sungkyul.bookmall.vo.BookVo;

public class BookMall {
	
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		int num = key.nextInt();
		
		BookDao dao = new BookDao();
		dao.rent(num);
		
		System.out.println("*****도서 정보 출력하기******");
		displayBookInfo();
		
	}
	
	public static void displayBookInfo() {
		BookDao dao = new BookDao();
		List<BookVo> list = new ArrayList<BookVo>();
		list = dao.getList();
		
		for(BookVo vo : list) {
			System.out.print("책 제목: " + vo.getTitle() + ", 저자: " + vo.getAuthorName() + ", 대여 유무: ");
			if(vo.getStatus() == 0) {
				System.out.println("재고 있음");				
			} else {
				System.out.println("대여중");
			}
			
		}
	}

}
