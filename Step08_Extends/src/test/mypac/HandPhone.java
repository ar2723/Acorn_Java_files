package test.mypac;

/*
 * 이미 존재하는 Phone 클래스를 extends(상속) 받아서 HandPhone 클래스 정의하기 
 */

//2개의 클래스를 한번에 상속받는 것(다중 상속)은 불가능하다.
public class HandPhone extends Phone {
	
	public HandPhone() {
		System.out.println("HandPhone 생성자 호출됨");
	}
	//메소드
	public void mobileCall() {
		System.out.println("이동 중에 전화를 걸어요");
	}
	//사진 찍는 메소드
	public void takePicture() {
		System.out.println("30만 화소의 사진을 찍어요");
	}
}
