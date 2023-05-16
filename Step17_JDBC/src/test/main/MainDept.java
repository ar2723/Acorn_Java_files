package test.main;

import java.util.List;

import test.dao.DeptDao;
import test.dto.DeptDto;
import test.dto.MemberDto;

public class MainDept {
	public static void main(String[] args) {
		System.out.println("-------- 단일 부서 정보 불러오기 --------");
		int deptno = 10;
		DeptDao dao = new DeptDao();
		DeptDto dto = dao.getData(deptno);
		
		System.out.println(dto.getDeptno()+" | "+dto.getDname()+" | "+dto.getLoc());
		
		System.out.println("-------- 모든 부서 정보 불러오기 --------");
		
		List<DeptDto> list = dao.getList();
		for(DeptDto tmp : list) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
		
		System.out.println("-------- 부서 정보 추가하기 --------");
		
		dao.insert(new DeptDto(50, "HR","HAWAI"));
		
		List<DeptDto> list2 = dao.getList();
		for(DeptDto tmp : list2) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
		
		System.out.println("-------- 부서 정보 수정하기 --------");
		
		dao.update(new DeptDto(50, "HRD", "KOREA"));
		
		List<DeptDto> list3 = dao.getList();
		for(DeptDto tmp : list3) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
		
		System.out.println("-------- 부서 정보 삭제하기 --------");
		
		dao.delete(50);
		
		List<DeptDto> list4 = dao.getList();
		for(DeptDto tmp : list4) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
		
	}
	
	
}
