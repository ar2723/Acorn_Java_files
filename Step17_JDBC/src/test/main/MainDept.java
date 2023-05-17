package test.main;

import java.util.List;

import test.dao.DeptDao;
import test.dto.DeptDto;
import test.dto.MemberDto;

public class MainDept {
	public static void main(String[] args) {
		System.out.println("-------- 단일 부서 정보 불러오기 --------");
		
		DeptDao dao = new DeptDao();
		
		DeptDto dto = dao.getData(10);
		if(dto!= null) {
			System.out.println(dto.getDeptno()+" | "+dto.getDname()+" | "+dto.getLoc());
		} else {
			System.out.println("입력한 번호에 해당하는 부서 정보는 존재하지 않습니다");
		}
		
		System.out.println("-------- 모든 부서 정보 불러오기 --------");
		
		List<DeptDto> list = dao.getList();
		for(DeptDto tmp : list) {
			System.out.println(tmp.getDeptno()+" | "+tmp.getDname()+" | "+tmp.getLoc());
		}
		
		System.out.println("-------- 부서 정보 추가하기 --------");
		
		dao.insert(new DeptDto(50, "HR","HAWAII"));
		
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
