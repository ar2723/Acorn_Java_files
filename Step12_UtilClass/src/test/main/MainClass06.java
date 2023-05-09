package test.main;

/*
 * 	JAVA에서 어떤 데이터를 key : value의 쌍으로 관리하고 싶으면 HashMap 객체를 사용한다.
 *
 *	key의 generic도 마음대로 지정할 수 있지만 보통 String type으로 한다.
 *	value의 generic은 그때 그때 다르지만 value가 여러가지 type이면 'Object'로 지정한다.
 */

import java.util.HashMap;
import test.mypac.Car;

public class MainClass06 {
	public static void main(String[] args) {
		//HashMap Utility는 Generic을 두개를 설정해주어야 하는데, 앞에 부분은 key의 generic이고
		//거의 String 타입으로 고정된다. 
		//뒤의 generic은 value 값으로 마찬가지로 Object로 고정해서 쓴다.
		//이는 문자열을 키값으로 해서 원하는 어떤 type의 value도 저장 할 수 있다.
		//이렇게 value의 타입을 Object로 고정하는 이유는 자바의 모든 데이터가 곧 Object type이기 때문이다.
		
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("num", 1); // Integer type 담기
		map1.put("name", "김구라"); // String type 담기
		map1.put("isMan", true); // Boolean type 담기
		map1.put("car", new Car("소나타")); // Car type 담기
		
		/*
		 * 	value의 Generic 클래스가 Object로 지정되어 있기 때문에
		 * 	리턴되는 Object type을 원래 type으로 casting 해야한다.
		 */
		
		int num  = (int)map1.get("num");
		String name  = (String)map1.get("name");
		Boolean isMan  = (Boolean)map1.get("isMan");
		Car car  = (Car)map1.get("car");
		
		//동일한 key 값으로 다시 담으면 수정
		map1.put("name", "에이콘");
		//특정 key 값으로 담긴 내용 삭제, 성공하면 true, 실패하면 false 리턴
		map1.remove("isMan");
		//모두 삭제
		map1.clear();
	}
}
