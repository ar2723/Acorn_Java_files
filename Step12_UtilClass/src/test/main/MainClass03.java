package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		//ArrayList 객체를 생성해서 참조값을 List 인터페이스 type 변수에 대입하기
		//이에 따라 List 인터페이스에 있는 메소드만을 사용할 수 있다.
		List<String> greets = new ArrayList<>();
		greets.add("hello");
		greets.add("hi");
		greets.add("good night");
		
		Consumer<String> con = new Consumer<>() {
			@Override
			// t = greets.get(i);
			public void accept(String t) {
				System.out.println("오잉 : "+t);
			}
		};
		
		//자바스크립트에서 forEach 메소드는 greets.forEach((item) => {}) 이렇게 사용된다.
		greets.forEach(con);
		
		System.out.println("---------------");
		
		greets.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println("오잉2 :"+ t);
			}
		});
		
		System.out.println("---------------");
		
		greets.forEach((t) -> {
			//public void accept(String t) {} = (t) -> {}
			//메소드가 오직 하나이기 때문에 이와 같이 줄여서 작성이 가능하다.
			//람다식에서는 따로 데이터 타입을 명시해주지 않아도 된다.
			System.out.println("오잉3 : "+ t);
		});
	}
}
