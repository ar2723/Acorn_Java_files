package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		//Car 객체를 생성해서 참조값을 Car type 지역변수 car1에 담기
		Car car1 = new Car();
		//car1에 담긴 참조값을 Car type 지역 변수 car2에 복사해주기
		Car car2 = car1;
		//Car type의 참조 값을 담을 수 있는 지역변수 car3 만들기
		Car car3 = null;
		
		car1.name="아반떼";
		String a=car1.name; // a = "아반떼"
		String b=car2.name; // b = "아반떼"
		
		//변수나 필드 앞에 붙이는 String, int와 같은 데이터 타입은 선언된 객체에 대한 사용 설명서를 제공해준다고 볼수있다.
		car1.drive();
		car2.drive();
		//NullPointerException 발생 car3 변수안에는 참조값이 없다.
		//따라서 객체안에 있는 메서드도 호출할 수 없다.
		car3.drive();
		
	}
}
