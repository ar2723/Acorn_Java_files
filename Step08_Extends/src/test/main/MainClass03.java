package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass03 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 HandPhone type 지역변수 p1에 담기
		HandPhone p1 = new HandPhone();
		
		// p1 안에 있는 참조값(HandPhone 객체의 참조값)을 p2라는 Phone type 지역 변수에 대입하기
		Phone p2 = p1;
		
		// p1 안에 있는 참조값(HandPhone 객체의 참조값)을 p3라는 Object type 지역 변수에 대입하기
		Object p3 = p1;
		
		//HandPhone p4 = p2(Phone type data); ->변수의 타입이 중요하기 때문에 들어있는 참조값(HandPhone 객체의 참조값)이 일치한다 하더라도 담을 수 없다.
		
		//자식 객체의 참조값은 부모 type 변수나 필드에 자연스럽게 담긴다.
		//변수의 type은 해당 객체의 필드와 메소드를 어디까지 쓸 수 있을지를 결정해준다.
	}
}
