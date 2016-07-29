package kr.ac.sungkyul.hr.app;

import java.util.List;
import java.util.Scanner;

import kr.ac.sungkyul.hr.dao.EmployeeDao;
import kr.ac.sungkyul.hr.vo.EmployeeVo;

public class HRApp {
	
	public static void main(String[] args) {		
//		searchByName();
		searchBySalary();
	}
	
	public static void searchByName() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("검색할 사원의 이름을 입력하세요");
		String name = scanner.nextLine();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(name);
		
		System.out.println("========================================================================================================");
		for(EmployeeVo vo : list) {
			System.out.println(vo);
		}
		
		if(scanner != null)	scanner.close();
	}
	
	
	
	public static void searchBySalary() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("임금(최저, 최고)");
		
		int minSalary = scanner.nextInt();
		int maxSalary = scanner.nextInt();
		
		EmployeeDao dao = new EmployeeDao();
		List<EmployeeVo> list = dao.getList(minSalary, maxSalary);		
		
		System.out.println(minSalary + ":" + maxSalary);
		
		System.out.println("========================================================================================================");
		for(EmployeeVo vo : list) {
			System.out.println(vo.getFirstName() + " " + vo.getLastName() + "\t" + vo.getSalary() );
		}
		
	}

}
