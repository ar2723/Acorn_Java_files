package test.main;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "덩어리";
		String addr = "목동";
		
		//추가할 회원의 정보를 MemberDto 객체에 담는다.
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		//DB에 저장하기
		new MemberDao().insert(dto);
		
		//DB에 저장된 data 삭제하기
		int num = 6;
		new MemberDao().delete(num);
		
		//DB에 저장된 data 수정하기
		int num1 = 1;
		String name1 = "이병헌";
		String addr1 = "청담동";
		
		MemberDto dto2 = new MemberDto();
		dto2.setNum(num1);
		dto2.setName(name1);
		dto2.setAddr(addr1);
		
		new MemberDao().update(dto2);
		
	}
}
