package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass04 {
	public static void main(String[] args) {
		//HandPhone 객체를 생성해서 나온 참조값을 Object type p3 라는 지역변수에 담아 보세요.
		Object p3 = new HandPhone();
		//Object type p3 변수에 담긴 값을 Phone type p2라는 변수에 담기
		//모든 object가 phone type이 아니기 때문에 아래 코드처럼 casting을 해주어야 한다.
		Phone p2 = (Phone)p3; //여기서 p2와 p3의 참조값은 동일하다.
		
		//Object type p3 변수에 담긴 값을 HandPhone type p1라는 변수에 담기
		HandPhone p1 = (HandPhone)p3;
	}
}
