package test.main;

import java.io.File;

import test.mypac.Airplane;
import test.mypac.Test;

public class MainClass01 {
	public static void main(String[] args) {
		Test t = new Test();
		//void를 리턴하는 메소드는 그냥 함수를 호출하고 마는 것이다.
		t.walk();
		//return type이 int인 메소드 호출하고 리턴되는 값을 a 라는 int type 지역변수에 담기
		int a = t.getNumber();
		//return type이 String인 메소드 호출하고 리턴되는 값을 b 라는 String type 지역변수에 담기
		String b = t.getGreeting();
		//return type이 AirPlane 인 메소드 호출하고 리턴되는 값을 c 라는 Airplane type 지역변수에 담기
		Airplane c = t.getPlane();
		c.fly();
		
		//위에서 생성한 객체의 setNum() 메소드를 호출해보세요.
		t.setNum(20);
		//위에서 생성한 객체의 setName() 메소드를 호출해보세요.
		t.setName("김구라");
		//위에서 생성한 객체의 setPlane() 메소드를 호출해보세요.
		t.setPlane(new Airplane());
		
		t.send();
		t.send(20);
		t.send("정세영");
		t.send(new Airplane());
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
