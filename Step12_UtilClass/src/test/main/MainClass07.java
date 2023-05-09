package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 세명의 회원정보를 HashMap 객체에 각각 담아서
		 * 
		 * ArrayList 객체에 누적시켜보세요.
		 * 
		 * 반복문 돌면서 ArrayList 객체에 누적된 회원정보를 콘솔창에 순서대로 출력해보세요.
		 * 
		 * (HashMap 객체 3개, ArrayList 객체 1개가 생성 되어야 합니다)
		 * 
		 * ArrayList 객체 안에 HashMap을 담을 예정이니
		 * List<HashMap<String, Object>> type이 필요합니다.
		 */
		
		//이와 같이 HashMap 유틸리티를 사용하는 것은 이전 예제에서 class를 생성해서 각 객체를 생성해서 필드에 값을 배정하고
		//사용하는 것보다 더 간편하다(인터페이스 구현과 자체 추가 메소드).
		
		Map<String, Object> mem1 = new HashMap<>();
		mem1.put("num", 1);
		mem1.put("name", "김구라");
		mem1.put("addr", "노량진");
		
		Map<String, Object> mem2 = new HashMap<>();
		mem2.put("num", 2);
		mem2.put("name", "해골");
		mem2.put("addr", "행신동");
		
		Map<String, Object> mem3 = new HashMap<>();
		mem3.put("num", 3);
		mem3.put("name", "원숭이");
		mem3.put("addr", "상도동");
		
		List<Map<String, Object>> memList = new ArrayList<>();
		memList.add(mem1);
		memList.add(mem2);
		memList.add(mem3);
		
		for(Map<String, Object> tmp: memList) {
			//번호
			int num = (int)tmp.get("num");
			//이름
			String name = (String)tmp.get("name");
			//주소
			String addr = (String)tmp.get("addr");
			
			System.out.println("번호 : "+num+", 이름 : "+name+", 주소 : "+addr);
			
		}
		
	}
}
