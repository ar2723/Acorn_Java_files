package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Consumer;

public class MainClass10 {
	public static void main(String[] args) {
		Set<String> names = new HashSet<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		names.add("주뎅이");
		names.add("덩어리");
		
		//반복자(Iterator) 객체 얻어내기 (저장된 item을 일렬로 세웠다고 생각하면 된다)
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String item = it.next();
			System.out.println(item);
		}
		
		System.out.println("-----");
		
		//위의 반복문을 더 간단하게 작성할 수 있는데,
		//바로 forEach 메소드의 Consumer 객체 인자 전달을 간략화해서 작성하는 방식을 이용하면 된다.
		names.forEach((item)->{
			System.out.println(item);
		});
		
		
		//특정 item(데이터, 참조값) 존재 여부 알아내기
		boolean isContain = names.contains("김구라"); //true
		//저장된 item의 갯수
		int size = names.size();
		//특정 item 삭제
		names.remove("해골");
		//모든 아이템 삭제
		names.clear();
	}
}
